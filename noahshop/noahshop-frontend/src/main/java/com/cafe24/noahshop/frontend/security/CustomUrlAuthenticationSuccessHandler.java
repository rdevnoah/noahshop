package com.cafe24.noahshop.frontend.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.cafe24.noahshop.frontend.dto.ResponseJSONResult;


public class CustomUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
    	
    	SavedRequest savedRequest = requestCache.getRequest( request, response );

        if ( savedRequest != null ) {
            requestCache.removeRequest( request, response );
            clearAuthenticationAttributes( request );
        }

		String accept = request.getHeader( "accept" );
    	
		SecurityUser securityUser = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal != null && principal instanceof UserDetails) {
				securityUser = (SecurityUser) principal;
			}

		}

    	if( accept == null || accept.matches( ".*application/json.*" ) == false ) {
    		HttpSession session = request.getSession(true);
    		session.setAttribute("authUser", securityUser);
    		// 회원인 경우 backend에서 cartInfo redis에서 가져오고 세팅하기

			Cookie[] cookies = request.getCookies();

			Cookie cartCookie = null;
			for (int i=0 ; i<cookies.length ; i++){
				if (cookies[i].getName().equals(securityUser.getName())){
					cartCookie = cookies[i];
					cartCookie.setValue(securityUser.getCartString());
					break;
				}
			}
			if (cartCookie == null){
				cartCookie = new Cookie(securityUser.getName(), securityUser.getCartString());
			}

			response.addCookie(cartCookie);

			// 이곳에 구현.



            getRedirectStrategy().sendRedirect( request, response, "/" );
    		return;
    	}
    	
    	MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    	MediaType jsonMimeType = MediaType.APPLICATION_JSON;
		
    	ResponseJSONResult jsonResult = ResponseJSONResult.success( securityUser );
    	if( jsonConverter.canWrite( jsonResult.getClass(), jsonMimeType ) ) {
        	jsonConverter.write( jsonResult, jsonMimeType, new ServletServerHttpResponse( response ) );
    	}
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }
}
