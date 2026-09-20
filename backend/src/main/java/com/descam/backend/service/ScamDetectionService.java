package com.descam.backend.service;

import com.descam.backend.responce.AnalyzeResponce;
import com.descam.backend.url.UrlAnalysisService;
import com.descam.backend.detection.MessageAnalysisService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScamDetectionService
{
  private final UrlAnalysisService urlAnalysisService;
  private final MessageAnalysisService messageAnalysisService;

  public ScamDetectionService
  (
    UrlAnalysisService urlAnalysisService,
    MessageAnalysisService messageAnalysisService
  )
  {
    this.urlAnalysisService = urlAnalysisService;
    this.messageAnalysisService = messageAnalysisService;
  }

  public AnalyzeResponce analyze(String message)
  {
    int score = 0;
    List<String> reasons = new ArrayList<>();
    String  extractedUrl = urlAnalysisService.extractUrl(message);
    String domain = null;
    boolean https = false;
    String lowerMessage = message.toLowerCase();

    List<String> messageIndicators = messageAnalysisService.detectIndicators(message);
    reasons.addAll(messageIndicators);

    if (extractedUrl != null)
    {
      score += 4;
      reasons.add("URL detected");

      domain = urlAnalysisService.extractDomain(extractedUrl);
      https = urlAnalysisService.isHttps(extractedUrl);
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

    return new AnalyzeResponce(riskLevel, score, reasons, extractedUrl, domain, https);
  }
}
