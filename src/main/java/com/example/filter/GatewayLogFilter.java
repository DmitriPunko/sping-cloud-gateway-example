package com.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class GatewayLogFilter implements GlobalFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayLogFilter.class);

    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, final GatewayFilterChain chain)
    {
        return chain.filter(exchange).doOnSuccessOrError(((aVoid, throwable) -> {
            HttpStatus statusCode = exchange.getResponse().getStatusCode();
            LOGGER.info(statusCode.toString());
        }));
    }
}


