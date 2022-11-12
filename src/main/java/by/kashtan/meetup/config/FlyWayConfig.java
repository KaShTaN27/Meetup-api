package by.kashtan.meetup.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FlyWayConfig {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String user;

    @Value("${spring.datasource.password}")
    String password;

    @PostConstruct
    public MigrateResult migrate() {
        return Flyway.configure()
                .dataSource(url, user, password)
                .load()
                .migrate();
    }
}
