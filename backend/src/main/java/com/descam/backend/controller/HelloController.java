package com.descam.backend.controller;

import com.descam.backend.dto.AnalyzeRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "Welcome to Descam!";
  }

  @PostMapping("/analyze")
  public String analyze(@RequestBody AnalyzeRequest request) {
    return "Received message: " + request.getMessage();
  }
}
