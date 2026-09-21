package com.descam.backend.detection;

public class DetectionIndicator
{
  private String type;
  private String description;
  private int score;
  
  public DetectionIndicator(
    String type,
    String description,
    int score
  ) {
    this.type = type;
    this.description = description;
    this.score = score;
  }

  public String getType()
  {
    return type;
  }

  public String getDescription()
  {
    return description;
  }

  public int getScore()
  {
    return score;
  }
}
