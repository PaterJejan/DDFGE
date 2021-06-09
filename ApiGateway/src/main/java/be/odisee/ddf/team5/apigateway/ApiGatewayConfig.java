package be.odisee.ddf.team5.apigateway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.cloud.client.circuitbreaker.Customizer;


import java.time.Duration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder){

        return routeLocatorBuilder.routes()
                //reservatie service
                .route(p -> p.path("/reservaties").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackReservaties"))).uri("http://localhost:8083"))
                .route(p -> p.path("/createReservatie").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackReservaties"))).uri("http://localhost:8083"))
                .route(p -> p.path("/updateReservatie").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackReservaties"))).uri("http://localhost:8083"))
                //.route(p -> p.path("/deleteReservatie/*").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackReservaties"))).uri("http://localhost:8083"))
                .route(p -> p.path("/reservatie/*").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackReservaties"))).uri("http://localhost:8083"))
                //lokalen service
                .route(p -> p.path("/lokalen").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLokalen"))).uri("http://localhost:8082"))
                .route(p -> p.path("/lokaal/*").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLokalen"))).uri("http://localhost:8082"))
                .route(p -> p.path("/updateLokaal").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLokalen"))).uri("http://localhost:8082"))
                //.route(p -> p.path("/deleteLokaal/*").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLokalen"))).uri("http://localhost:8082"))
                .route(p -> p.path("/createLokaal").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLokalen"))).uri("http://localhost:8082"))
                //login service
                .route(p -> p.path("/persoons").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLogin"))).uri("http://localhost:8081"))
                //het vermijden van bruteforce logins door het request limiters op te stellen
                .route(p -> p.path("/login/*").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLoginL")).requestRateLimiter().configure(c->c.setRateLimiter(redisRateLimiter())) ).uri("http://localhost:8081"))
                .route(p -> p.path("/persoon/*").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLogin"))).uri("http://localhost:8081"))
                .route(p -> p.path("/updatePersoon").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLogin"))).uri("http://localhost:8081"))
                .route(p -> p.path("/createPersoon").filters(f -> f.circuitBreaker(c->c.setName("codedTribeCB").setFallbackUri("/defaultFallbackLogin"))).uri("http://localhost:8081"))

                .build();
    }

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer()
    {
        return factory->factory.configureDefault(id ->new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(2)).build()).build());
    }

    /**
     * Maxmale aanvragen limiteren
     * @return
     */
    @Bean
    public RedisRateLimiter redisRateLimiter()
    {
        //hoeveel request kan doen in 1 seconde
        return new RedisRateLimiter(1,2);
    }

    @Bean
    public ReactiveResilience4JCircuitBreakerFactory factory()
    {
        return new ReactiveResilience4JCircuitBreakerFactory();
    }


}
