package hu.keratomi.logbackkibana.stubclasses;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
public interface LogMessagePrinter {
    List<String> WORDS_FOR_LOG = Arrays.asList("error", "username", "transaction", "login", "exit", "start", "finish");

    void printLogMessage();

    default String pickOneWord() {
        Random r = new Random();
        return WORDS_FOR_LOG.get(r.nextInt(WORDS_FOR_LOG.size()));
    }
}
