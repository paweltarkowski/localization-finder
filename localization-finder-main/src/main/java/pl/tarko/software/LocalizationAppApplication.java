package pl.tarko.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.tarko.software.finder.LocalizationCoreConfiguration;

@SpringBootApplication
@Import(LocalizationCoreConfiguration.class)
public class LocalizationAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocalizationAppApplication.class, args);
    }
}
