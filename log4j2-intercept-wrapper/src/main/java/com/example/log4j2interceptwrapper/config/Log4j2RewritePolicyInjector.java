//package com.example.log4j2interceptwrapper.config;
//
//import org.apache.logging.log4j.core.Appender;
//import org.apache.logging.log4j.core.LoggerContext;
//import org.apache.logging.log4j.core.config.AppenderRef;
//import org.apache.logging.log4j.core.config.Configuration;
//import org.apache.logging.log4j.core.appender.rewrite.RewriteAppender;
////import org.apache.logging.log4j.core.appender.rewrite.RewriteAppender.Builder;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Log4j2RewritePolicyInjector implements ApplicationListener<ApplicationStartedEvent> {
//
//    @Override
//    public void onApplicationEvent(ApplicationStartedEvent event) {
//        System.out.println("injecting ......");
//        LoggerContext ctx = (LoggerContext) LoggerContext.getContext(false);
//        Configuration config = ctx.getConfiguration();
//
//        // Get existing STDOUT appender from consumer config
//        Appender consoleAppender = config.getAppender("Console"); // STDOUT
//        if (consoleAppender == null) {
//            System.err.println("STDOUT appender not found. Skipping RewritePolicy injection.");
//            return;
//        }
//
//        // NOT WORKING
//        // Create RewriteAppender wrapping STDOUT
////        RewriteAppender rewriteAppender = RewriteAppender.newBuilder()
////                .setName("RewriteWrapper")
////                .setRewritePolicy(new CustomRewritePolicy())
////                .setConfiguration(config)
////                .setAppenderRef(consoleAppender) // "STDOUT"
////                .build();
//
//        // Register AppenderRef[] not Appender[]
//        AppenderRef[] appenderRefs = {
//                AppenderRef.createAppenderRef("Console", null, null)
//        };
//
//        // Create RewriteAppender using factory method
//        RewriteAppender rewriteAppender = RewriteAppender.createAppender(
//                "RewriteWrapper",
//                null,
//                appenderRefs,
//                config,
//                new CustomRewritePolicy(),
//                null
//        );
//
//        rewriteAppender.start();
//        config.addAppender(rewriteAppender);
//
//        // Attach RewriteWrapper to root logger (non-invasively)
//        config.getRootLogger().addAppender(rewriteAppender, null, null);
//        ctx.updateLoggers();
//    }
//}
