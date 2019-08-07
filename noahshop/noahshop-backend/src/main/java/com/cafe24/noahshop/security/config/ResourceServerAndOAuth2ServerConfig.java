package com.cafe24.noahshop.security.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.security.config
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-08-07       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-07
 */
@Configuration
public class ResourceServerAndOAuth2ServerConfig {

    @Configuration
    @EnableResourceServer
    public static class ResourceServerConfig extends ResourceServerConfigurerAdapter {



        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.headers().frameOptions().disable();

            // 자원 서버 접근 권한 설정
            http
                    .authorizeRequests()
                    //.antMatchers("/").access("#oauth2.hasScope('read')")
                    .anyRequest()
                    .access("#oauth2.hasScope('read') and #oauth2.hasScope('write')");
        }

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId("v1");
        }
    }

    @Configuration
    @EnableAuthorizationServer
    public static class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            // password or authorization code
    //		clients.inMemory()
    //			.withClient("pjmall")
    //			.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
    //			.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
    //			.scopes("read", "write", "trust")
    //			.resourceIds("sparklr")
    //			.accessTokenValiditySeconds(60);

    //		// client credentials
    //		clients.inMemory()
    //			.withClient("noahshop")
    //			.authorizedGrantTypes("password", "client_credentials")
    //			.authorities("ROLE_CLIENT")
    //			.scopes("read", "write", "trust")
    //			.resourceIds("v1")
    //			.secret("1234");
                //.accessTokenValiditySeconds(60);

            clients.jdbc(dataSource());


    //		clients
    //			.jdbc(dataSource());
    //			.and()
    //			.withClient("my-client-with-registered-redirect")
    //			.authorizedGrantTypes("authorization_code") .authorities("ROLE_CLIENT") .scopes("read", "trust") .resourceIds("sparklr") .redirectUris("http://localhost:8080") .and() .withClient("my-client-with-secret") .authorizedGrantTypes("client_credentials", "password") .authorities("ROLE_CLIENT") .scopes("read") .resourceIds("sparklr") .secret("secret");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            // OAuth2 서버가 작동하기 위한 Endpoint에 대한 정보를 설정
            endpoints
                    .tokenStore( new JdbcTokenStore(dataSource()) )
                    .authenticationManager(authenticationManager);
        }

        @Bean
        @ConfigurationProperties("spring.datasource")
        public DataSource dataSource() throws SQLException {
            return new BasicDataSource();
        }

    }


}
