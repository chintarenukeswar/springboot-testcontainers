package com.example.firstapp.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@Configuration
public class QualifiersConfiguration {
    @Bean
    ApplicationListener<ApplicationReadyEvent> andriod(@Andriod MobileMarketPlace mobileMarketPlace){
        return event -> System.out.println(mobileMarketPlace.getClass().toString());
    }
    @Bean
    ApplicationListener<ApplicationReadyEvent> apple(@Apple MobileMarketPlace mobileMarketPlace){
        return event -> System.out.println(mobileMarketPlace.getClass().toString());
    }
    @Bean
    ApplicationListener<ApplicationReadyEvent> mobileMarketListners(Map<String,MobileMarketPlace> mobileMarketPlaceMap) {
        return event -> mobileMarketPlaceMap.forEach((key,bean) -> System.out.println(key+"=="+bean.getClass()));
    }
}


interface MobileMarketPlace{}

@Service
@Qualifier("ios")
class AppStore implements MobileMarketPlace{}

@Service
@Qualifier("andriod")
class PlayStore implements MobileMarketPlace{}

@Retention(RetentionPolicy.RUNTIME)
@Qualifier("ios")
@interface Apple{}

@Retention(RetentionPolicy.RUNTIME)
@Qualifier("andriod")
@interface Andriod{}