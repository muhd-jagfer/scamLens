package com.descam.backend.service;

import org.springframework.stereotype.Service;

@Service 
public class ScamDetectionService {

  public String analyze(String message) {
    return "Analysis completed for: " + message;
  }
}
