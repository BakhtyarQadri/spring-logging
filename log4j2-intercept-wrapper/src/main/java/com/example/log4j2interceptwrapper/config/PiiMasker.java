package com.example.log4j2interceptwrapper.config;

//public class PiiMasker {
//
//    public static String maskSensitiveData(String logMsg) {
//        // Mask MSISDN (show only last 4 digits)
//        logMsg = logMsg.replaceAll("\\b(\\d{4})(\\d{4})(\\d{4})(\\d{4})\\b", "************$4");
//
//        // Mask email (show first 2 chars only)
//        logMsg = logMsg.replaceAll("\\b(\\w{2})\\w+@(\\S+)", "$1****@$2");
//
//        // Add more patterns here (landline, credit cards, etc.)
//        return logMsg;
//    }
//
//}

import java.util.regex.Pattern;

public class PiiMasker {
    // Regex patterns for common PII
    private static final Pattern MSISDN_PATTERN =
            Pattern.compile("(\\+?\\d{1,3}[- ]?)?(\\d{3,4})[- ]?(\\d{3,4})[- ]?(\\d{4})");
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("\\b([A-Za-z0-9._%+-]{3})[A-Za-z0-9._%+-]*@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})\\b");
    private static final Pattern LANDLINE_PATTERN =
            Pattern.compile("\\b(\\d{2,4})[- ]?(\\d{3,4})[- ]?(\\d{4})\\b");
    private static final Pattern CREDIT_CARD_PATTERN =
            Pattern.compile("\\b(\\d{4})[- ]?(\\d{4})[- ]?(\\d{4})[- ]?(\\d{4})\\b");

    public static String maskSensitiveData(String logMsg) {
        if (logMsg == null || logMsg.isEmpty()) {
            return logMsg;
        }

        // Mask email (e.g. john.doe@example.com → joh***@example.com)
        logMsg = EMAIL_PATTERN.matcher(logMsg).replaceAll("$1***@$2");

        // Mask MSISDN (e.g. +1 234 567 8901 → +X XXX XXX 8901)
        logMsg = MSISDN_PATTERN.matcher(logMsg).replaceAll(mr -> {
            if (mr.group(4) != null) { // If we matched the full pattern
                return (mr.group(1) != null ? maskAll(mr.group(1)) + " " : "") +
                        (mr.group(2) != null ? maskAll(mr.group(2)) + " " : "") +
                        (mr.group(3) != null ? maskAll(mr.group(3)) + " " : "") +
                        mr.group(4);
            }
            return maskAll(mr.group()); // Fallback
        });

        // Mask landline (e.g. 022-1234-5678 → XXX-XXXX-5678)
        logMsg = LANDLINE_PATTERN.matcher(logMsg).replaceAll(mr -> {
            if (mr.group(3) != null) {
                return maskAll(mr.group(1)) + "-" +
                        maskAll(mr.group(2)) + "-" +
                        mr.group(3);
            }
            return maskAll(mr.group()); // Fallback
        });

        // Mask credit cards (e.g. 1234 5678 9012 3456 → XXXX XXXX XXXX 3456)
        logMsg = CREDIT_CARD_PATTERN.matcher(logMsg).replaceAll("XXXX XXXX XXXX $4");

        return logMsg;
    }

    private static String maskAll(String input) {
        return input.replaceAll("[0-9]", "X").replaceAll("[A-Za-z]", "*");
    }
}