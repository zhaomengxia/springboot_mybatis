package com.springboot_springdatajpa.springdatajpa;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringdatajpaApplication {
	private static Log logger = LogFactory.get();
	public static void main(String[] args) {
		ConfigurableApplicationContext application=SpringApplication.run(SpringdatajpaApplication.class, args);
		Environment env = application.getEnvironment();

		logger.info("\n----------------------------------------------------------\n\t" +
						"SpringdatajpaApplication  is running! Access URLs:\n\t" +
						"Doc: \thttp://localhost:{}/swagger-ui.html#\n" +
						"----------------------------------------------------------",

				env.getProperty("server.port"));
	}

}
