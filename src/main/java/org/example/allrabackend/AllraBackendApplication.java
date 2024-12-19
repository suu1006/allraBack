package org.example.allrabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AllraBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllraBackendApplication.class, args);
    }

}
