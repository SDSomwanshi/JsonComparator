package com.test.JsonComparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : Swapil S
 * @created on : 04/10/2020, Fri
 **/

@SpringBootApplication
@EnableSwagger2
public class JsonComparatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonComparatorApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
