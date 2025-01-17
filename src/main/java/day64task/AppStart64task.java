package day64task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppStart64task {
    public static void main(String[] args) {
        SpringApplication.run(AppStart64task.class);
    }
}
