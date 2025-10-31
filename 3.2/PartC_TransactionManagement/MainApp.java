package com.example.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService service = context.getBean(AccountService.class);
        service.transfer(1, 2, 500.0);

        context.close();
    }
}