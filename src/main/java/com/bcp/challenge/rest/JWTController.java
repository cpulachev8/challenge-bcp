package com.bcp.challenge.rest;

import com.bcp.challenge.dto.request.JWTRequest;
import com.bcp.challenge.security.JwtAuthenticationFilter;
import com.bcp.challenge.security.JwtTokenProvider;
import com.bcp.challenge.security.UserMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JWTController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @SuppressWarnings("rawtypes")
    @PostMapping("/token")
    public ResponseEntity authenticateUser(@RequestBody JWTRequest jwtRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtRequest.getUsername(),
                        jwtRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserMain userMain = (UserMain) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String jwt = tokenProvider.generateToken(userMain.getUsername());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtAuthenticationFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(jwtRequest, httpHeaders, HttpStatus.OK);
    }

}
