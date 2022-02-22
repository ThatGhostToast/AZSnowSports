package com.azsnowsports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.azsnowsports.business.BlogBusinessService;
import com.azsnowsports.business.BlogBusinessServiceInterface;
import com.azsnowsports.business.UserBusinessService;
import com.azsnowsports.business.UserBusinessServiceInterface;

@Configuration
public class SpringConfig {
	@Bean(name="userBusinessService")
	public UserBusinessServiceInterface getUsersBusiness()
	{
		return new UserBusinessService();
	}
	
	@Bean(name="blogBusinessService")
	public BlogBusinessServiceInterface getBlogBusiness()
	{
		return new BlogBusinessService();
	}
}
