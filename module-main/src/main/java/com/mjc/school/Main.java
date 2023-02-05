package com.mjc.school;

import com.mjc.school.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppManager appManager = context.getBean(AppManager.class);

        appManager.start();
    }
}
