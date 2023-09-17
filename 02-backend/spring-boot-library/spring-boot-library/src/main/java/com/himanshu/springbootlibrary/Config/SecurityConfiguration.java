package com.himanshu.springbootlibrary.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import com.okta.spring.boot.oauth.Okta;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		//disable cross site request forgery
		http.csrf().disable();
		
		//protect endpoints at /api/<type>/secure
		http.authorizeRequests(configurer -> 
		configurer
		.antMatchers("/api/books/secure/**",
				"/api/reviews/secure/**")
		.authenticated())
		.oauth2ResourceServer()
		.jwt();
		
		
		
		//add CORS filter
		http.cors();
		
		//add content negotiation strategy
		http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());
		
		//force non empty response body for 401 to make it friendly
		Okta.configureResourceServer401ResponseBody(http);
		return http.build();
	}

}
