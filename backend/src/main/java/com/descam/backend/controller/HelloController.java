package com.descam.backend.controller;

import com.descam.backend.dto.AnalyzeRequest;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "Welcome to Descam!";
  }

  @PostMapping("/analyze")
  public String analyze(@Valid @RequestBody AnalyzeRequest request) {
    return "Received message: " + request.getMessage();
  }
}
