package hu.keratomi.logbackkibana.stubclasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoClassWithInfoLog implements LogMessagePrinter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoClassWithInfoLog.class);

    @Override
    public void printLogMessage() {
        LOGGER.info("This is an info message with word: {}", pickOneWord());
    }

    @Override
    public String toString() {
        return "DemoClassWithInfoLog";
    }
}
