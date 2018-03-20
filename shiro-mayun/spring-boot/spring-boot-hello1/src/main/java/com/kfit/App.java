package com.kfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
//其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
@SpringBootApplication 
@RestController
public class App {
	
	@RequestMapping("/")
    public String hello(){
		return "Hello world!";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
