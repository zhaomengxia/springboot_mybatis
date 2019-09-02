package com.springboot_mybatis_module.springboot_mybatis_module;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.springboot_mybatis_module.springboot_mybatis_module.dao")
public class SpringbootMybatisModuleApplication {

	private static Log logger = LogFactory.get();
	public static void main(String[] args) {
		ConfigurableApplicationContext application =SpringApplication.run(SpringbootMybatisModuleApplication.class, args);
		Environment env = application.getEnvironment();

		logger.info("\n----------------------------------------------------------\n\t" +
						"SpringbootMybatisModuleApplication  is running! Access URLs:\n\t" +
						"Doc: \thttp://localhost:{}/swagger-ui.html#\n" +
						"----------------------------------------------------------",

				env.getProperty("server.port"));
	}

}
