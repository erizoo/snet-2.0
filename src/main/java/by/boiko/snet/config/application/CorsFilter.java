//package by.boiko.snet.config.application;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//@EnableWebMvc
//public class CorsFilter extends OncePerRequestFilter {
//
//    @Bean
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        if (request.getHeader("Access-Control-Request-Method") != null
//                && "OPTIONS".equals(request.getMethod())) {
//            // CORS "pre-flight" request
//            response.addHeader("Access-Control-Allow-Methods",
//                    "GET, POST, PUT, DELETE");
//            response.addHeader("Access-Control-Allow-Headers",
//                    "X-Requested-With,Origin,Content-Type, Accept");
//        }
//        filterChain.doFilter(request, response);
//    }
//
//}