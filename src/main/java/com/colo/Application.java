package com.colo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.sql.*;
import java.util.Arrays;

/**
 * Created by rehacek on 10/3/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan
public class Application extends SpringBootServletInitializer {

//    @Autowired
//    private ThymeleafProperties properties;
//
//    @Value("${spring.thymeleaf.templates_root:}")
//    private String templatesRoot;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

//    @Bean
//    public ITemplateResolver defaultTemplateResolver() {
//        FileTemplateResolver resolver = new FileTemplateResolver();
//        resolver.setSuffix(properties.getSuffix());
//        resolver.setPrefix(templatesRoot);
//        resolver.setTemplateMode(properties.getMode());
//        resolver.setCacheable(properties.isCache());
//        return resolver;
//    }

}
