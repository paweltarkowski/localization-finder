package pl.tarko.software.finder;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableCaching
public class LocalizationCoreConfiguration {

    @Value("${liquibase.change-log}")
    private String changeLogDir;

    @Value("${liquibase.contexts}")
    private String liquibaseContexts;

    @Bean(name = "liquibase")
    public SpringLiquibase configLiquibase(DataSource configDataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(configDataSource);
        liquibase.setChangeLog(changeLogDir);
        liquibase.setContexts(liquibaseContexts);
        return liquibase;
    }
}
