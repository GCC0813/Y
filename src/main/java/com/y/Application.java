package com.y;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.y.mapper")
/*@EnableAutoConfiguration*/
@SpringBootApplication
@EnableAdminServer
@Configuration
@Log4j2
@ServletComponentScan
public class Application {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		//springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

}
