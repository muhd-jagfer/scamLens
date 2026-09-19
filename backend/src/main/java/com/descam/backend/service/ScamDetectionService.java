package com.descam.backend.service;

import com.descam.backend.responce.AnalyzeResponce;
import com.descam.backend.url.UrlAnalysisService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScamDetectionService
{
  private final UrlAnalysisService urlAnalysisService;

  public ScamDetectionService(UrlAnalysisService urlAnalysisService)
  {
    this.urlAnalysisService = urlAnalysisService;
  }

  public AnalyzeResponce analyze(String message)
  {
    int score = 0;
    List<String> reasons = new ArrayList<>();
    String  extractedUrl = urlAnalysisService.extractUrl(message);
    String domain = null;
    String lowerMessage = message.toLowerCase();

    if (lowerMessage.contains("urgent"))
    {
      score += 2;
      reasons.add("Urgent Language Detected");
    }
    
    if (lowerMessage.contains("otp") || lowerMessage.contains("password") || lowerMessage.contains("pin"))
    {
      score += 4;
      reasons.add("Sensitive information request detected");
    }

    if (lowerMessage.contains("click this link") || lowerMessage.contains("verify your account"))
    {
      score += 2;
      reasons.add("Suspicious action request detected");
    }

    if (lowerMessage.contains("bank") || lowerMessage.contains("account will be blocked"))
    {
      score += 3;
      reasons.add("Account or Banking threat detected");
    }

    if (extractedUrl != null)
    {
      score += 4;
      reasons.add("URL detected");

      domain = urlAnalysisService.extractDomain(extractedUrl);
    }

    String riskLevel;
    if (score >= 6)
    {
      riskLevel = "HIGH";
    } else if (score >= 3)
    {
      riskLevel = "SUSPICIOUS";
    } else
    {
      riskLevel = "LOW";
    }

    return new AnalyzeResponce(riskLevel, score, reasons, extractedUrl, domain);
  }
}
