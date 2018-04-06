package com.akhambir.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.akhambir.services",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = {CategoryService.class, NotificationService.class, MailService.class}))
public class ServiceTestConfiguration {

    /*@Bean
    public UserServiceImpl userServiceImpl() {
        return new UserServiceImpl();
    }*/

}
