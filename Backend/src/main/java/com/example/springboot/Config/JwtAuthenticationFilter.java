// package com.example.springboot.Config;

// import static org.springframework.http.HttpHeaders.AUTHORIZATION;

// import java.io.IOException;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.lang.NonNull;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.example.springboot.Utils.JwtUtil;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;

// @Component
// @RequiredArgsConstructor
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

//     private final JwtUtil jwtUtil;
//     private final UserDetailsService userDetailsService;

//     @Override
//     protected void doFilterInternal(
//             @NonNull HttpServletRequest request,
//             @NonNull HttpServletResponse response,
//             @NonNull FilterChain filterChain)
//             throws ServletException, IOException {
//         final String authHeader = request.getHeader(AUTHORIZATION);
//         final String token;
//         final String userEmail;
//         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//             filterChain.doFilter(request, response);
//             return;
//         }
//         token = authHeader.substring(7);
//         userEmail = jwtUtil.extractUsername(token);

//         logger.info("User Email: {}", userEmail);
//         logger.info("Token: {}", token);

//         if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

//             logger.info("Is Token Valid: {}", jwtUtil.isTokenValid(token, userDetails));

//             if (jwtUtil.isTokenValid(token, userDetails)) {
//                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
//                         null, userDetails.getAuthorities());
//                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(authToken);
//             }
//         }
//         filterChain.doFilter(request, response);
//     }
// }
