package com.alfonsoframework.app.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.alfonsoframework.app")
@PropertySource("classpath:/environment-${env:dev}.properties")
public class TestConfig {
}
