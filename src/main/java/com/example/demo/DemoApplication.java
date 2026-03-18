package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        try {
            String publicIp = new BufferedReader(
                    new InputStreamReader(new URL("http://checkip.amazonaws.com").openStream())
            ).readLine();

            System.out.println("\n🔥 You can access the application with: http://" + publicIp + ":8085\n");

        } catch (Exception e) {
            System.out.println("Unable to fetch public IP");
        }
    }

    @GetMapping("/")
    public String home() {
        return """
            <html>
                <body style="margin:0; background-color:#0a2540; display:flex; justify-content:center; align-items:center; height:100vh;">
                    <h1 style="color:white;">
                        Hello, Spring Boot is running on port 8085!
                    </h1>
                </body>
            </html>
            """;
    }
}
