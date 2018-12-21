package net.homenet.configuration;

import net.homenet.service.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

//# 1.
@EnableWebMvc
@Configuration
@ComponentScan("net.homenet.controller")
public class CustomerWebConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
            .addResourceLocations("/WEB-INF/resources/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Autowired
    private MessageSource messageSource;

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource);
        return validator;
    }

    //# Handle exception use the HandlerExceptionResolver
    @Bean
    public HandlerExceptionResolver handlerExceptionResolver() {
        Properties props = new Properties();
        props.setProperty(DataNotFoundException.class.getName(), "customer/notfound");

        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        resolver.setExceptionMappings(props);
        return resolver;
    }
}

//# 2.MatrixVariable 활성화
//@Configuration
//@ComponentScan("net.homenet.controller")
//public class CustomerWebConfiguration extends DelegatingWebMvcConfiguration {
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**")
//            .addResourceLocations("/WEB-INF/resources/");
//    }
//
//    @Override
//    protected void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/views/", ".jsp");
//    }
//
//    @Autowired
//    private MessageSource messageSource;
//
//    @Override
//    protected Validator getValidator() {
//        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//        validator.setValidationMessageSource(messageSource);
//        return validator;
//    }
//
//    @Override
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//        RequestMappingHandlerMapping handlerMapping = super.requestMappingHandlerMapping();
//        handlerMapping.setRemoveSemicolonContent(false);
//        return handlerMapping;
//    }
//}
