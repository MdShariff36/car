package com.booking.demo.utility;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import io.github.bucket4j.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitingFilter implements Filter {

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String ip = request.getRemoteAddr();

        Bucket bucket = buckets.computeIfAbsent(ip, k -> newBucket());

        if (bucket.tryConsume(1)) {
            chain.doFilter(req, res); // allow request
        } else {
            response.setStatus(429); // Too Many Requests
            response.getWriter().write("Rate limit exceeded. Please try again later.");
        }
    }

    private Bucket newBucket() {
        Bandwidth limit = Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1))); // 5 requests/min
        return Bucket.builder().addLimit(limit).build();
    }
}
