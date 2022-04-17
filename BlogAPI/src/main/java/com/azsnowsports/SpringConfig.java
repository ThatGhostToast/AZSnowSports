package com.azsnowsports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azsnowsports.business.BlogBusinessService;

/**
 * @author Zac Almas and Austin Driver
 * 
 * Configuration file for the application
 */
@Configuration
public class SpringConfig {	
	/**
	 * Blog business service bean
	 * @return Returns a new blog business service
	 */
	@Bean(name="blogBusinessService")
	public BlogBusinessService getBlogBusiness()
	{
		return new BlogBusinessService();
	}
	
}
