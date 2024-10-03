package com.usuario.usuario.infrastructure.jwt;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import jakarta.servlet.http.HttpServletRequest;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private final Long userId;

    public CustomWebAuthenticationDetails(HttpServletRequest request, Long userId) {
        super(request);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}