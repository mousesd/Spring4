package net.homenet;

//# 1.
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextClosedEvent;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.ContextStartedEvent;
//import org.springframework.context.event.ContextStoppedEvent;
//
//public class ApplicationContextEventListener implements ApplicationListener {
//    @Override
//    public void onApplicationEvent(ApplicationEvent event) {
//        if (event instanceof ContextRefreshedEvent) {
//            System.out.println("*** ContextRefreshedEvent ***");
//        } else if (event instanceof ContextStartedEvent) {
//            System.out.println("*** ContextStartedEvent ***");
//        } else if (event instanceof ContextStoppedEvent) {
//            System.out.println("*** ContextStoppedEvent ***");
//        } else if (event instanceof ContextClosedEvent) {
//            System.out.println("*** ContextClosedEvent ***");
//        }
//    }
//}

//# 2.
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//public class ApplicationContextEventListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        System.out.println("*** ContextRefreshedEvent ***");
//    }
//}

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

//# 3.
public class ApplicationContextEventListener {
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("*** ContextRefreshedEvent ***");
    }
}