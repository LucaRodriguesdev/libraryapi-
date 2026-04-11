package io.github.luca.libraryapi.controller.mappers;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        if(username.equals("admin") && password.equals("123")) {
            return "login ok";
        }

        throw new RuntimeException("Credenciais inválidas");
    }

    @GetMapping("/hash")
    public String hash() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder(10).encode("123456");
    }
}
