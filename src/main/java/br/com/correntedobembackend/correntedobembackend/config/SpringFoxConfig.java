package br.com.correntedobembackend.correntedobembackend.config;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static br.com.correntedobembackend.correntedobembackend.constants.SwaggerConstants.*;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@EnableWebMvc
@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {


    @Bean
    public Docket apiDocket(){
        return new Docket(SWAGGER_2).apiInfo(apiInfo()).forCodeGeneration(true)
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey())).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.regex(SECURE_PATH)).build()
                .tags(new Tag(API_TAG, "All APIs relating to corrente do bem"));

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(API_TITLE, API_DESCRIPTION, API_VERSION, TERM_OF_SERVICE, contact(), LICENSE, LICENSE_URL, Collections.emptyList());
    }

    private Contact contact(){
        return new Contact(CONTACT_NAME,CONTACT_URL,CONTACT_EMAIL);
    }

    private ApiKey apiKey(){
        return new ApiKey(SECURITY_REFERENCE,AUTHORIZATION, SecurityScheme.In.HEADER.name());
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(securityReference()).build();
    }

    private List<SecurityReference> securityReference(){
        AuthorizationScope[] authorizationScope = {new AuthorizationScope(AUTHORIZATION_SCOPE, AUTHORIZATION_DESCRIPTION)};
        return Collections.singletonList(new SecurityReference(SECURITY_REFERENCE, authorizationScope));
    }


//    public static final String AUTHORIZATION_HEADER = "Authorization";
//    public static final String DEFAULT_INCLUDE_PATTERN = "/*/.*";
//    private final Logger log = LoggerFactory.getLogger(SpringFoxConfig.class);
//
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .pathMapping("/")
//                .apiInfo(ApiInfo.DEFAULT)
//                .genericModelSubstitutes(ResponseEntity.class)
//                .ignoredParameterTypes(java.sql.Date.class)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .securityContexts(Lists.newArrayList(securityContext()))
//                .securitySchemes(Lists.newArrayList(apiKey()))
//                .useDefaultResponseMessages(true);
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
//                .build();
//    }
//
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope
//                = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Lists.newArrayList(
//                new SecurityReference("JWT", authorizationScopes));
//    }
}