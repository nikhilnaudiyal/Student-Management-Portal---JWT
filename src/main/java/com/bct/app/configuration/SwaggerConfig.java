package com.bct.app.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
//	public static final String AUTHORIZATION_HEADER = "Authorization";
//	
//	
//	private ApiKey apikeys()
//	{
//		return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");
//	}
//	
//	private List<SecurityContext> securityContexts()
//	{
//		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
//	}
//	
//	private List<SecurityReference> sf()
//	{
//		AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
//		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] { scope }));
//	}

    @Bean
    public Docket swaggerAppConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
        		//.apiInfo(getInfo())
        		//.securityContexts(securityContexts())
        		//.securitySchemes(Arrays.asList(apikeys()))
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.bct.app"))
                .build();
    }

//	private ApiInfo getInfo() {
//	
//		return new ApiInfo("Student Management Portal", null, null, null, null, null, null);
//	}
}