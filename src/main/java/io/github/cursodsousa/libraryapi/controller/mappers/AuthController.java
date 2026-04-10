package io.github.cursodsousa.libraryapi.controller.mappers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}