package interview.hibernate.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerCfg {
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.paths(PathSelectors.ant("/v1/cache/*"))
                .apis(RequestHandlerSelectors.basePackage("interview.hibernate.cache.controller"))
                .build()
                .apiInfo(apiDetails());
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Demo for 1: Inheritance of Entity 2: Immute Entity update 3: ",
                "Hibernate Demo",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("tony rong","wwww.tonyrong.com", "tonyrong@ggg.com"),
                "API Licentse",
                "http://wwww.tonyrong.com",
                        Collections.emptyList()
        );
    }
}
