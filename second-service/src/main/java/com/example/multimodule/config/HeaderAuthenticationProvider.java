package com.example.multimodule.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class HeaderAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String authenticationPrincipal = (String) authentication.getPrincipal();
        return getValidationToken(authenticationPrincipal);
    }

    private Authentication getValidationToken(String customToken) {
        return new PreAuthenticatedAuthenticationToken("AuthenticatedUser", "ROLE_ADMIN");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthenticatedAuthenticationToken.class.equals(authentication);
    }
}
