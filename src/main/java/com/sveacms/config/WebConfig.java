package com.sveacms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Gäller alla endpoints
                        .allowedOrigins(
                                "http://localhost:3000", // för lokal React-dev
                                "https://www.levantinsights.com", // Netlify-produktionsdomän
                                "https://levantsite.netlify.app" // ev. Netlify-preview
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true); // om du använder cookies/autentisering
            }
        };
    }
}
