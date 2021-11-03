package com.codexist.codexistworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableSwagger2
//@EnableJpaRepositories
@ComponentScan(basePackages = {"com.example.dbmodel"})
public class CodexistWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodexistWorkshopApplication.class, args);
    }

}
