package com.example.log4j2interceptwrapper.config;

import com.example.log4j2interceptwrapper.config.MaskedLogEvent;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.message.Message;

public class CustomRewritePolicy implements RewritePolicy {

    @PluginFactory
    public static CustomRewritePolicy createPolicy() {
        return new CustomRewritePolicy();
    }

    @Override
    public LogEvent rewrite(LogEvent source) {

        // ignore startup default logs
        if (source.getThreadName().equals("main") || !source.getLoggerName().startsWith("com.example")) {
            return source;
        }
        Message logMsg = source.getMessage();
        String formattedLogMsg = logMsg.getFormattedMessage();
        String maskedLogMsg = PiiMasker.maskSensitiveData(formattedLogMsg);
        return new MaskedLogEvent(source, maskedLogMsg);
    }
}
