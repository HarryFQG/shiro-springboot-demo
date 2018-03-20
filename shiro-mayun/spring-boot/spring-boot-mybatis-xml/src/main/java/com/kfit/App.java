package com.kfit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot 启动类.
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年8月27日
 */
@SpringBootApplication
@MapperScan("com.kfit.*.mapper")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
