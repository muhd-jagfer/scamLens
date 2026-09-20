package com.descam.backend.detection;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageAnalysisService
{
    public List<String> detectIndicators(String message)
    {
      List<String> indicators = new ArrayList<>();
      String lowerMessage = message.toLowerCase();

      if (lowerMessage.contains("urgent"))
      {
        indicators.add("Urgent Language detected");
      }

      if (lowerMessage.contains("otp") || lowerMessage.contains("password") || lowerMessage.contains("pin"))
      {
        indicators.add("Sensitive information request detected");
      }

      if (lowerMessage.contains("click this link") || lowerMessage.contains("verify your account"))
      {
        indicators.add("Suspicious action request detected");
      }

      if (lowerMessage.contains("bank") || lowerMessage.contains("account will be blocked"))
      {
        indicators.add("Account or banking threat detected");
      }

      return indicators;
    }
}
