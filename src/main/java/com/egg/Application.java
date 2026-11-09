package com.egg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        loadMongoUriFromDotEnv();
        SpringApplication.run(Application.class, args);
    }

    private static void loadMongoUriFromDotEnv() throws IOException {
        if (System.getenv("MONGODB_URI") != null || System.getProperty("MONGODB_URI") != null) {
            return;
        }

        Path envFile = Path.of(".env");
        if (!Files.exists(envFile)) {
            return;
        }

        for (String line : Files.readAllLines(envFile)) {
            String trimmed = line.trim();
            if (trimmed.isEmpty() || trimmed.startsWith("#")) {
                continue;
            }

            int separator = trimmed.indexOf('=');
            if (separator < 0 || !trimmed.substring(0, separator).trim().equals("MONGODB_URI")) {
                continue;
            }

            String value = trimmed.substring(separator + 1).trim();
            if (value.length() >= 2
                    && ((value.startsWith("\"") && value.endsWith("\""))
                    || (value.startsWith("'") && value.endsWith("'")))) {
                value = value.substring(1, value.length() - 1);
            }
            System.setProperty("MONGODB_URI", value);
            return;
        }
    }
}
