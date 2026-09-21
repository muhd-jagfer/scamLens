package com.descam.backend.detection;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageAnalysisService {

    public List<DetectionIndicator> detectIndicators(String message) {

        List<DetectionIndicator> indicators = new ArrayList<>();

        String lowerMessage = message.toLowerCase();

        if (lowerMessage.contains("urgent")) {
            indicators.add(
                    new DetectionIndicator(
                            "URGENCY",
                            "Urgent language detected",
                            2
                    )
            );
        }

        if (lowerMessage.contains("otp")
                || lowerMessage.contains("password")
                || lowerMessage.contains("pin")) {

            indicators.add(
                    new DetectionIndicator(
                            "SENSITIVE_INFORMATION",
                            "Sensitive information request detected",
                            4
                    )
            );
        }

        if (lowerMessage.contains("click this link")
                || lowerMessage.contains("verify your account")) {

            indicators.add(
                    new DetectionIndicator(
                            "SUSPICIOUS_ACTION",
                            "Suspicious action request detected",
                            2
                    )
            );
        }

        if (lowerMessage.contains("bank")
                || lowerMessage.contains("account will be blocked")) {

            indicators.add(
                    new DetectionIndicator(
                            "ACCOUNT_THREAT",
                            "Account or banking threat detected",
                            3
                    )
            );
        }

        return indicators;
    }
}