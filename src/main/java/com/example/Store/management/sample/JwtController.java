//package com.example.Store.management.sample;
//
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class JwtController {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public JwtController() {
//        this.jwtTokenProvider = new JwtTokenProvider();
//    }
//
//    @GetMapping("/generate-token")
//    public String generateToken(@RequestParam String username) {
//        return jwtTokenProvider.generateToken(username);
//    }
//
//    @GetMapping("/validate-token")
//    public boolean validateToken(@RequestParam String token) {
//        return jwtTokenProvider.validateToken(token);
//    }
//
//}
//
