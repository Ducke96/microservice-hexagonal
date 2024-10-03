package com.usuario.usuario.infrastructure.jwt;

import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;
import java.util.stream.Collectors;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       
        final String token = getTokenFromRequest(request);
        final String username;

        if (token==null)
        {
            filterChain.doFilter(request, response);
            return;
        }

        username=jwtService.getUsernameFromToken(token);
         // Extraer roles desde el token
        List<String> roles = jwtService.getClaim(token, claims -> claims.get("roles", List.class));
        Long id = jwtService.getClaim(token, claims -> claims.get("id", Long.class));
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails userDetails=userDetailsService.loadUserByUsername(username);
            

            if (jwtService.isTokenValid(token, userDetails))
            {
                UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                     // Convertir a GrantedAuthority
                    );

                    CustomWebAuthenticationDetails customDetails = new CustomWebAuthenticationDetails(request, id);
                    authToken.setDetails(customDetails); // Almacenar los detalles personalizados
            
                //authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //authToken.setDetails(id);

                SecurityContextHolder.getContext().setAuthentication(authToken);
                
            }

        }
        
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer "))
        {
            return authHeader.substring(7);
        }
        return null;
    }



    
}