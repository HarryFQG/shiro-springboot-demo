package com.kfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 
 * @SpringBootApplication申明让spring boot自动给程序进行必要的配置，
 * 
@SpringBootApplication
等待于：
@Configuration
@EnableAutoConfiguration
@ComponentScan
 * 
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@SpringBootApplication 
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
