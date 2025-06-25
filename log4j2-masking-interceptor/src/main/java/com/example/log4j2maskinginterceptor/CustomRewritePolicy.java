package com.example.log4j2maskinginterceptor;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.message.Message;

@Plugin(name = "CustomRewritePolicy", category = "Core", elementType = "rewritePolicy", printObject = true)
public class CustomRewritePolicy implements RewritePolicy {

    @PluginFactory
    public static CustomRewritePolicy createPolicy() {
        return new CustomRewritePolicy();
    }

    @Override
    public LogEvent rewrite(LogEvent source) {
        if (!source.getLoggerName().startsWith("com.example")) { // can exclude irrelevant thread logs -> source.getThreadName().equals("main")
            return source;
        }
        Message logMsg = source.getMessage();
        String formattedLogMsg = logMsg.getFormattedMessage();
        String maskedLogMsg = UserInfoMasker.maskUserInfo(formattedLogMsg);
        return new MaskedLogEvent(source, maskedLogMsg);
    }
}
