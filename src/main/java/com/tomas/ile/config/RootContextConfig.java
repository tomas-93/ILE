package com.tomas.ile.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 12/08/2016
 */
@Configuration
@EnableTransactionManagement(
        mode = AdviceMode.PROXY,
        proxyTargetClass = false,
        order = Ordered.LOWEST_PRECEDENCE)
@ComponentScan(
        basePackages = "com.tomas.*",
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootContextConfig
{
    @Bean
    public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasenames(
                "WEB-INF/i18n/titles", "WEB-INF/i18n/messages",
                "WEB-INF/i18n/errors", "WEB-INF/i18n/validation"
        );
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean()
    {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(this.messageSource());
        return validator;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        MethodValidationPostProcessor processor =
                new MethodValidationPostProcessor();
        processor.setValidator(this.localValidatorFactoryBean());
        return processor;
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        return mapper;
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller()
    {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.tomas.*");
        return marshaller;
    }

    /**
     * =============================================>Hibernate
     */
    public DataSource dataSource()
    {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        driverManagerDataSource.setUsername("tomas");
        driverManagerDataSource.setPassword("tomas");
        return driverManagerDataSource;
    }

    private Properties properties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }

    @Bean
    @Scope(value = "singleton")
    public LocalSessionFactoryBean localSessionFactoryBean()
    {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("com.tomas.ile");
        localSessionFactoryBean.setHibernateProperties(properties());
        return localSessionFactoryBean;
    }

    @Bean
    @Scope(value = "singleton")
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }
}
