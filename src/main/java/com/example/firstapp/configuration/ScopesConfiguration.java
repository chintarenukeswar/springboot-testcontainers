package com.example.firstapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Configuration
public class ScopesConfiguration {
}

@Component
//@RequestScope
class RequestScopeContext{
    private final String uuid = UUID.randomUUID().toString();
    public String uuid(){
        return uuid;
    }
}

@RestController
class ContextHttpControoler{
    private final RequestScopeContext requestScopeContext;

    ContextHttpControoler(RequestScopeContext requestScopeContext) {
        this.requestScopeContext = requestScopeContext;
    }
    @GetMapping("/scopes/context")
    public String uuid(){
        return this.requestScopeContext.uuid();
    }
}