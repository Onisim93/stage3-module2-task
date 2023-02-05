package com.mjc.school.main;

import com.mjc.school.main.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppManager manager = context.getBean(AppManager.class);

        manager.start();
    }
}
