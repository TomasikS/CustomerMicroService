package com.sovy;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CustomerResource.class);
    }
}
