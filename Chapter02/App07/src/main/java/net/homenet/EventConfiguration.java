package net.homenet;

//# 1, 2
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class EventConfiguration {
//    @Bean
//    public ApplicationListener applicationListener() {
//        return new ApplicationContextEventListener();
//    }
//}

//# 3.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfiguration {
    @Bean
    public ApplicationContextEventListener applicationContextEventListener() {
        return new ApplicationContextEventListener();
    }
}
