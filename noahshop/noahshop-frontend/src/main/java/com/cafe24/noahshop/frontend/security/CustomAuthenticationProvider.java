package com.cafe24.noahshop.frontend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

import java.util.Collection;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.frontend.security
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
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }


    @Autowired
    private UserDetailsService userDetailService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        System.out.println("check password############### - " + password);

        SecurityUser securityUser = null;
        Collection<GrantedAuthority> authorities = null;
        try{
            securityUser = (SecurityUser) userDetailService.loadUserByUsername(username);
            System.out.println("real password############### - " + securityUser.getPassword());
            // 이 부분에 패스워드 인코더로 match 검사
            if (!password.equals(securityUser.getPassword())){
                throw new BadCredentialsException("비밀번호 불일치");
            }
            authorities = (Collection<GrantedAuthority>) securityUser.getAuthorities();
        } catch(UsernameNotFoundException e){
            throw new UsernameNotFoundException(e.getMessage());
        } catch(BadCredentialsException e){
            throw new BadCredentialsException(e.getMessage());
        }

        UsernamePasswordAuthenticationToken authenticate = new UsernamePasswordAuthenticationToken(username, password, authorities);
        Object result = authenticate.getPrincipal();
        System.out.println(result + "--------------------------result");
        return new UsernamePasswordAuthenticationToken(securityUser, securityUser.getPassword(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
