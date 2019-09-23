package com.springsecurityjwt.springsecurityjwt;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.springsecurityjwt.springsecurityjwt.util.ApplicationUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringsecurityjwtApplication {
	private static Log logger = LogFactory.get();
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ApplicationUtil applicationUtil() {
		return new ApplicationUtil();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(SpringsecurityjwtApplication.class, args);
		Environment env = applicationContext.getEnvironment();
		logger.info("\n----------------------------------------------------------\n\t" +
						"SpringsecurityjwtApplication  is running! Access URLs:\n\t" +
						"Doc: \thttp://localhost:{}/swagger-ui.html#\n" +
						"----------------------------------------------------------",
				env.getProperty("server.port"));
	}

}
