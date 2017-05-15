package pl.tarko.software.finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(LocalizationCoreConfiguration.class)
public class LocalizationMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocalizationMainApplication.class, args);
    }
}
