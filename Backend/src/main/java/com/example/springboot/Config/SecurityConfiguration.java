// package com.example.springboot.Config;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// import lombok.RequiredArgsConstructor;

// @Configuration
// @EnableWebMvc
// @EnableMethodSecurity
// @RequiredArgsConstructor
// public class SecurityConfiguration {
//     private final AuthFilterService authFilterService;
//     private final AuthenticationProvider authenticationProvider;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .csrf(AbstractHttpConfigurer::disable)
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/api/users/**","/forgotPassword/**")
//                         .permitAll()
//                         .requestMatchers("/api/admin/**")  // Example for admin access
//                         .hasRole("ADMIN")  // Admin role requirement
//                         .anyRequest()
//                         .authenticated())
//                 .sessionManagement(session -> session
//                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                 .authenticationProvider(authenticationProvider)
//                 .addFilterBefore(authFilterService, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }
// }
