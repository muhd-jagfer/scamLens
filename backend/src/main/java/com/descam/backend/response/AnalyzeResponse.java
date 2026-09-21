package com.descam.backend.response;

import java.util.List;

public class AnalyzeResponse {

    private String riskLevel;
    private int score;
    private List<String> reasons;
    private String extractedUrl;
    private String domain;
    private boolean https;

    public AnalyzeResponse(
            String riskLevel,
            int score,
            List<String> reasons,
            String extractedUrl,
            String domain,
            boolean https) {

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