package com.descam.backend.responce;

import java.util.List;

public class AnalyzeResponce
{
  private String riskLevel;
  private int score;
  private List<String> reasons;
  private String extractedUrl;
  private String domain;
  private boolean https;

  public AnalyzeResponce(String riskLevel, int score, List<String> reasons,  String extractedUrl, String domain, boolean https)
  {
    this.riskLevel = riskLevel;
    this.score = score;
    this.reasons = reasons;
    this.extractedUrl = extractedUrl;
    this.domain = domain;
    this.https = https;
  }

  public String getRiskLevel() {
    return riskLevel;
  }

  public int getScore() {
    return score;
  }

  public List<String> getReasons() {
    return reasons;
  }

  public String getExtractedUrl() {
    return extractedUrl;
  }

  public String getDomain() {
    return domain;
  }

  public boolean isHttps() {
    return https;
  }

}
