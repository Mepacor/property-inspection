package com.propertyinspection.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.propertyinspection")
public class PropertyInspectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyInspectionApplication.class, args);
    }
}
