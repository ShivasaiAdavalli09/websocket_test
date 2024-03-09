package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sendGreetings() {
    	System.out.print("hello");
        return "Hello, World!";
    }
    
    @GetMapping("/chatLive")
    public String chatLive() {
        return "ws://localhost:8081/websocket";
    }
    @GetMapping("/")
    public String index() {
        return "index.html"; // Return the HTML page with JavaScript WebSocket client
    }
}
