package com.example.jwt.controller;

import com.example.jwt.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
public ResponseEntity<?> authenticate(HttpServletRequest request) {
    try {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        String[] credentials = new String(Base64.getDecoder().decode(header.substring(6)), StandardCharsets.UTF_8)
                .split(":", 2);

        if (credentials.length < 2) {
            return ResponseEntity.status(400).body("Invalid basic auth format");
        }

        String username = credentials[0];
        String password = credentials[1];
        

        if ("yogesh".equals(username) && "y1810".equals(password)) {
            String token = JwtUtil.generateToken(username);
            return ResponseEntity.ok().body("{\"token\":\"" + token + "\"}");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }


    }
}
