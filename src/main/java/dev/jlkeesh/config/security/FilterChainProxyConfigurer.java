package dev.jlkeesh.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class FilterChainProxyConfigurer extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}
