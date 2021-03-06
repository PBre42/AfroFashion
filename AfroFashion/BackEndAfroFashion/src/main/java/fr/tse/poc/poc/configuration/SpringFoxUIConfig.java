package fr.tse.poc.poc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class SpringFoxUIConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

            registry.addRedirectViewController("/v2/api-docs", "/v2/api-docs?group=restful-api");
            registry.addRedirectViewController("/swagger-resources/configuration/ui","/swagger-resources/configuration/ui");
            registry.addRedirectViewController("/swagger-resources/configuration/security","/swagger-resources/configuration/security");
            registry.addRedirectViewController("/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
             registry
                   .addResourceHandler("/swagger-ui.html**")
                   .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
            registry
                   .addResourceHandler("/webjars/**")
                   .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}