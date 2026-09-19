package com.descam.backend.responce;

import java.util.List;

public class AnalyzeResponce
{
  private String riskLevel;
  private int score;
  private List<String> reasons;
  private String extractedUrl;
  private String domain;

  public AnalyzeResponce(String riskLevel, int score, List<String> reasons,  String extractedUrl, String domain)
  {
    this.riskLevel = riskLevel;
    this.score = score;
    this.reasons = reasons;
    this.extractedUrl = extractedUrl;
    this.domain = domain;
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

}
