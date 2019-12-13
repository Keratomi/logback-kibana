package hu.keratomi.logbackkibana.controller;

import hu.keratomi.logbackkibana.LogbackKibanaApplication;
import hu.keratomi.logbackkibana.stubclasses.LogMessagePrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
public class GenerateLogEntriesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateLogEntriesController.class);

    private List<LogMessagePrinter> logMessagePrinters;

    @Autowired
    public GenerateLogEntriesController(List<LogMessagePrinter> logMessagePrinters) {
        this.logMessagePrinters = logMessagePrinters;
    }

    @GetMapping("/")
    public String generateLogEntries(@RequestParam("logRowCount") int logRowCount) {
        for (int i = 0; i < logRowCount; i++) {
            Random r = new Random();
            LogMessagePrinter logMessagePrinter = logMessagePrinters.get(r.nextInt(logMessagePrinters.size()));
            LOGGER.info("Selected printer instance: {}", logMessagePrinter);
            logMessagePrinter.printLogMessage();
        }

        return "Log entries has been generated successfully.";
    }
}
