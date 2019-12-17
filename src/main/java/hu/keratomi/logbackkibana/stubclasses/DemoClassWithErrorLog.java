package hu.keratomi.logbackkibana.stubclasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DemoClassWithErrorLog implements LogMessagePrinter {

    private static List<Throwable> ERRORS;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoClassWithErrorLog.class);

    @Override
    public void printLogMessage() {
        Random r = new Random();
        LOGGER.error("This is an error message", ERRORS.get(r.nextInt(ERRORS.size())));
    }

    @PostConstruct
    private void fillErrorList() {
        ERRORS = Arrays.asList(
                new NullPointerException(String.format("Error word %s",  pickOneWord())),
                new IllegalArgumentException(String.format("Error word %s",  pickOneWord())),
                new IllegalStateException(String.format("Error word %s",  pickOneWord()))
        );
    }

    @Override
    public String toString() {
        return "DemoClassWithErrorLog";
    }
}
