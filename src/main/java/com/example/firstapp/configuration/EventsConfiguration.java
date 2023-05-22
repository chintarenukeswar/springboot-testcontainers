package com.example.firstapp.configuration;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class EventsConfiguration {
    @Bean
    ApplicationListener<WebServerInitializedEvent> webServerInitializedEventApplicationListener(){
        return event -> run("ApplicationListener<WebServerInitializedEvent>", event);
    }

    @EventListener
    public  void applicationEventListener(ApplicationReadyEvent event){
        run("@EvenLsitner",event);
    }
    private void run(String where , ApplicationEvent event){
        System.out.println(where + "----"+ event);
    }
}
