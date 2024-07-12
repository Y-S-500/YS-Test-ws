package com.AMONIC.Airlines;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class AirlinesApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AirlinesApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Añade un pequeño retardo para asegurarte de que el servidor está completamente iniciado
        Thread.sleep(5000);

        String swaggerUrl = "http://localhost:9000/Airlines/swagger-ui/index.html";
        openBrowser(swaggerUrl);
    }

    // Método para abrir el navegador
    public static void openBrowser(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        try {
            if (os.contains("win")) {
                // Windows
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                // macOS
                rt.exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                // Linux/Unix
                String[] browsers = {"google-chrome", "firefox", "mozilla", "xdg-open"};
                StringBuilder cmd = new StringBuilder();
                for (int i = 0; i < browsers.length; i++) {
                    if (i == 0) {
                        cmd.append(String.format("%s \"%s\"", browsers[i], url));
                    } else {
                        cmd.append(String.format(" || %s \"%s\"", browsers[i], url));
                    }
                }
                rt.exec(new String[]{"sh", "-c", cmd.toString()});
            } else {
                throw new UnsupportedOperationException("Unsupported operating system.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
