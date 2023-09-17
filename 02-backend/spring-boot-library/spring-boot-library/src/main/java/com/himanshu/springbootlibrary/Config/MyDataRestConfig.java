package com.himanshu.springbootlibrary.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.himanshu.springbootlibrary.Entity.Book;
import com.himanshu.springbootlibrary.Entity.Review;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	private String theAllowedOrigins = "http://localhost:3000";
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] theUnsupportedActions = {
				HttpMethod.POST,
				HttpMethod.DELETE,
				HttpMethod.PATCH,
				HttpMethod.PUT};
		
		config.exposeIdsFor(Book.class);//spring boot automatically hides id thats why we exposed in postman json
		config.exposeIdsFor(Review.class);//spring boot automatically hides id thats why we exposed in postman json data
		
		disableHttpMethods(Book.class,config,theUnsupportedActions);
		disableHttpMethods(Review.class, config, theUnsupportedActions);
		
		/*Configuration CORS Mapping*/
		cors.addMapping(config.getBasePath() + "/**")
		.allowedOrigins(theAllowedOrigins);
	}
	
	private void disableHttpMethods(Class theClass,RepositoryRestConfiguration config,HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration()
		.forDomainType(theClass)
		.withItemExposure((metadata,HttpMethods) ->
				HttpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata,httpMethods) ->
				httpMethods.disable(theUnsupportedActions));
	}
	

}
