package com.example.log4j2interceptwrapper.config;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.impl.MutableLogEvent;
import org.apache.logging.log4j.message.SimpleMessage;

public class MaskedLogEvent extends MutableLogEvent {

    public MaskedLogEvent(LogEvent source, String maskedMessage) {
        initFrom(source);
        setMessage(new SimpleMessage(maskedMessage));
    }

}
