package com.course.business.config;

import tk.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.course.server.mapper")
@ComponentScan("com.course")
public class BusinesssApplication {

	private static final Logger LOG = LoggerFactory.getLogger(BusinesssApplication.class);


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BusinesssApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("启动成功！！");
		LOG.info("Businesss: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}

}
