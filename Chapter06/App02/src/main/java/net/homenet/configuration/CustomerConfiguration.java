package net.homenet.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan("net.homenet.service")
public class CustomerConfiguration {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/META-INF/messages");
        return messageSource;
    }

    //# CustomerWebConfiguration.getValidator() 메서드에서 대체
    //@Bean
    //public Validator globalValidator(MessageSource messageSource) {
    //    LocalValidatorFactoryBean globalValidator = new LocalValidatorFactoryBean();
    //    globalValidator.setValidationMessageSource(messageSource);
    //    return globalValidator;
    //}
}
