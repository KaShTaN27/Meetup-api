package by.kashtan.meetup.config;

import by.kashtan.meetup.model.Event;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Value("${spring.jpa.database-platform}")
    private String dialect;

    @Bean
    public SessionFactory getSessionFactory() {
        var config = new Configuration()
                .addProperties(configureHibernateProperties())
                .addAnnotatedClass(Event.class);
        var serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        return config.buildSessionFactory(serviceRegistry);
    }

    public Properties configureHibernateProperties() {
        var properties = new Properties();
        properties.put("hibernate.connection.url", url);
        properties.put("dialect", dialect);
        properties.put("hibernate.connection.username", username);
        properties.put("hibernate.connection.password", password);
        properties.put("hibernate.connection.driver_class", driverName);
        return properties;
    }
}
