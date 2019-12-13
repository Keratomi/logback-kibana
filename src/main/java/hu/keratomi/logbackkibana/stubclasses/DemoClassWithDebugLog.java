package hu.keratomi.logbackkibana.stubclasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoClassWithDebugLog implements LogMessagePrinter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoClassWithDebugLog.class);

    @Override
    public void printLogMessage() {
        LOGGER.debug("This is a debug message with word: {}", pickOneWord());
    }

    @Override
    public String toString() {
        return "DemoClassWithDebugLog";
    }
}
