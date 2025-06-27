package com.example.log4j2maskinginterceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoMasker {

//    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\b([a-zA-Z])([a-zA-Z\\.]*)(@[^,\\s]+)"); // failing for 'text1 and 'text2'
//    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\b([a-zA-Z])([a-zA-Z\\.]*)(@\\w+(?:\\.\\w+)+)\\b"); // failing for 'text3'
    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\b([a-zA-Z0-9])([a-zA-Z0-9\\.]*)(@\\w+(?:\\.\\w+)+)\\b");
    private static final Pattern MSISDN_PATTERN = Pattern.compile("(\\+?(20|212|213|216|235|253|961|962|964|965|966|967|968|970|971|973))(\\d{3,8})(\\d{4})\\b");
    private static final String LANDLINE_PATTERN = "\\b1\\d{4}(\\d{4})\\b";
    private static final String LANDLINE_MASKED_PATTERN = "*****$1";
    private static final String ASTERISK = "*";

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
                masked = firstChar + ASTERISK.repeat(middle.length()) + domain;
            } else {
                masked = ASTERISK.repeat(1) + domain; // Handle case where only single character exists before @
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
            String masked = ASTERISK.repeat(starsCount) + last4;
            matcher.appendReplacement(result, masked);
        }
        matcher.appendTail(result);
        logMsg = result.toString();


        // masking LANDLINE
        logMsg = logMsg.replaceAll(LANDLINE_PATTERN, LANDLINE_MASKED_PATTERN);

        return logMsg;
    }

}