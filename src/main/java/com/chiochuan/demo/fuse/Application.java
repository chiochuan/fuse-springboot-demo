package com.chiochuan.demo.fuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * A spring-boot application that includes a Camel route builder to setup the Camel routes
 */
@SpringBootApplication
@EnableTransactionManagement
// @EnableAutoConfiguration(exclude = {
// DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
// HibernateJpaAutoConfiguration.class
// })
@ImportResource({
    "classpath:spring/camel-context.xml", "classpath:spring/beans.xml", "classpath:spring/app-context.xml"
})
public class Application {

    // must have a main method spring-boot can run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
