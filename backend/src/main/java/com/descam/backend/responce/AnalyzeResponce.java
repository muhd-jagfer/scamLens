package com.descam.backend.responce;

import java.util.List;

public class AnalyzeResponce {
  
  private String riskLevel;
  private int score;
  private List<String> reasons;

  public AnalyzeResponce(String riskLevel, int score, List<String> reasons) {
    this.riskLevel = riskLevel;
    this.score = score;
    this.reasons = reasons;
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
}
