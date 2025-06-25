package com.example.log4j2maskinginterceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoMasker {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\b([a-zA-Z])([a-zA-Z\\.]*)(@[^,\\s]+)");
    private static final Pattern MSISDN_PATTERN = Pattern.compile("(\\+?(20|212|213|216|235|253|961|962|964|965|966|967|968|970|971|973))(\\d{3,6})(\\d{4})\\b"); // minDigits = 7 & maxDigits = 10 (excluding country code)

    public static String maskUserInfo(String logMsg) {
        if (logMsg == null || logMsg.isEmpty()) {
            return logMsg;
        }

        // masking EMAIL
        Matcher matcher = EMAIL_PATTERN.matcher(logMsg);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String firstChar = matcher.group(1);
            String middle = matcher.group(2);
            String domain = matcher.group(3);
            String masked;
            if (middle.length() > 0) {
                masked = firstChar + "*".repeat(middle.length()) + domain;
            } else {
                masked = "*".repeat(1) + domain; // mask even if single character exists before @
            }
            matcher.appendReplacement(result, masked);
        }
        matcher.appendTail(result);
        logMsg = result.toString();

        // masking MSISDN
        matcher = MSISDN_PATTERN.matcher(logMsg);
        result = new StringBuffer();
        while (matcher.find()) {
            String prefix = matcher.group(1);
            String middle = matcher.group(3);
            String last4 = matcher.group(4);
            int starsCount = prefix.length() + middle.length();
            String masked = "*".repeat(starsCount) + last4;
            matcher.appendReplacement(result, masked);
        }
        matcher.appendTail(result);
        logMsg = result.toString();

        return logMsg;
    }

}