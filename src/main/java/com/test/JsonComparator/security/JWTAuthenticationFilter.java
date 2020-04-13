package com.test.JsonComparator.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.JsonComparator.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.test.JsonComparator.security.SecurityConstants.*;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            User creds = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>()
                    )
            );
        }catch (IOException ie) {
            throw new RuntimeException(ie);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                         FilterChain chain,
                                         Authentication auth) throws IOException, ServletException {
        String token = JWT.create()
                        .withSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
                        .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
