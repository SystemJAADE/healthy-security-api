package com.systemjaade.healthy.controller;

import com.systemjaade.healthy.model.HealthyAuthRequest;
import com.systemjaade.healthy.util.JwtUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthyAuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public String generateToken(@RequestBody HealthyAuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            DigestUtils.sha1Hex(authRequest.getUsername()),
                            DigestUtils.sha1Hex(authRequest.getPassword())
                    )
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(DigestUtils.sha1Hex(authRequest.getUsername()));
    }

}
