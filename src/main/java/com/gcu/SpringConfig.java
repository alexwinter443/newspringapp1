package com.gcu;

import com.gcu.business.ProductBusinessService;
import com.gcu.business.ProductBusinessServiceInterface;
import com.gcu.business.SecurityService;
import com.gcu.business.SecurityServiceInterface;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Elijah Olmos and Alex vergara
 * Milestone
 * 02/02/2022
 */
@Configuration
public class SpringConfig {
	
	@Bean(name="securityService")
	public SecurityServiceInterface getSecurityService()
	{
		
		return new SecurityService();
		
	}
	
	@Bean(name="productBusinessService", initMethod="init", destroyMethod="destroy")
	public ProductBusinessServiceInterface getOrdersBusiness() {
		return new ProductBusinessService();
	}

}
