package fr.tse.poc.poc.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    private final BuildProperties buildProperties;

    @Autowired
    public SpringFoxConfig(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

    private ApiInfo info() {
        Contact contact = new Contact("Test Developper", "", "test@test.fr");

        return new ApiInfoBuilder()
                .title(buildProperties.getName())
                .description(buildProperties.get("description"))
                .version(buildProperties.getVersion())
                .contact(contact)
                .license("MIT")
                .licenseUrl("http://opensource.org/licenses/MIT")
                .version("1.0")
                .build();
    }
}
