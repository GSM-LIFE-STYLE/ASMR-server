package lifestyle.awardscore.global.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile(value = {"dev"})
public class SwaggerConfig {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ASMR")
                .description("ASMR, Award Score Management Respect?")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ASMR")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.server.ASMR"))
                .paths(PathSelectors.ant("/v1/**"))
                .build();
    }
}
