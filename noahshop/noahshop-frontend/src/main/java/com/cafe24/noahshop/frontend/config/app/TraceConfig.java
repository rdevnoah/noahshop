package com.cafe24.noahshop.frontend.config.app;

import brave.CurrentSpanCustomizer;
import brave.SpanCustomizer;
import brave.Tracing;
import brave.context.log4j2.ThreadContextScopeDecorator;
import brave.http.HttpClientAdapter;
import brave.http.HttpTracing;
import brave.httpclient.TracingHttpClientBuilder;
import brave.propagation.B3Propagation;
import brave.propagation.ExtraFieldPropagation;
import brave.propagation.ThreadLocalCurrentTraceContext;
import brave.spring.webmvc.SpanCustomizingAsyncHandlerInterceptor;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.frontend.config.app
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-08-19       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-19
 */
@Configuration
@Import(SpanCustomizingAsyncHandlerInterceptor.class)
public class TraceConfig extends WebMvcConfigurerAdapter {

    @Bean
    Sender sender(){
        return OkHttpSender.create("http://localhost:9411/api/v2/spans");
    }

    @Bean
    AsyncReporter<Span> spanReporter(){
        return AsyncReporter.create(sender());
    }

    @Bean
    Tracing tracing(@Value("${zipkin.service:noahshop-frontend}") String serviceName) {
        return Tracing.newBuilder()
                .localServiceName(serviceName)
                .propagationFactory(ExtraFieldPropagation.newFactory(B3Propagation.FACTORY, "user-name"))
                .currentTraceContext(ThreadLocalCurrentTraceContext.newBuilder()
                        .addScopeDecorator(ThreadContextScopeDecorator.create())
                        .build())
                .spanReporter(spanReporter()).build();
    }

    @Bean
    SpanCustomizer spanCustomizer(Tracing tracing){
        return CurrentSpanCustomizer.create(tracing);
    }

    @Bean
    HttpTracing httpTracing(Tracing tracing){
        return HttpTracing.create(tracing);
    }

    @Bean
    HttpClient httpClient(HttpTracing httpTracing){
        return TracingHttpClientBuilder.create(httpTracing).build();
    }

    @Autowired
    SpanCustomizingAsyncHandlerInterceptor serverInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serverInterceptor);
    }
}
