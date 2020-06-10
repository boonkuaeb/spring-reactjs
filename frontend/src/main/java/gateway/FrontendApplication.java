package gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@SpringBootApplication
public class FrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bypath", r -> r.path("/api/*")
                        .filters(f -> f.addRequestHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huQGdtYWlsLmNvbSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJuYW1lIjoiSm9obiIsImlkIjoiMSIsImV4cCI6MTU5MTgxMTU5MiwidXNlck5hbWUiOiJqb2huQGdtYWlsLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfQ1JFQVRFX05PVEUiLCJST0xFX1ZJRVdfTk9URSIsIlJPTEVfRURJVF9OT1RFIiwiUk9MRV9ERUxFVEVfTk9URSIsIlJPTEVfVklFV19BTExfTk9URSJdLCJqdGkiOiIxZjc2MjFkOS1kNWMzLTQ0YWItOTA4Mi0zNGEyZmIyNWY5ZmYiLCJjbGllbnRfaWQiOiJ0YWxrMmFtYXJlc3dhcmFuIn0.Mknj46Zs-bh6-Qo07mBdjaE5wRZPnr9j8vZDkoUbUSYmG_Nudxq4xMk97dkwgE-dUpiMi-Jduv5WM3jH_an0JcwBQvP2ANbTJTdFE6WB0Ups8L10rb-1blecZ6lCDrICVKq4NpIgqXwhKUAD2ThpvyjoXi-8gQslZDM75Za5_5JsXL0xeIwqmiEvOz0wmhGj0rVE1ab6K31_U05EvKTlY6RLK1cnTPiSNHRKP-9d1nS-fMS_noXcZxiqHmtDWnkgAjpOETUMy2QoV8yiafSDE0Xz8FBYM7eMPRDsBiBbbRlHRJBKCXZNaoG_SEKXPINIZVARIUp2GBPVi46d24K2Uw"))
                        .uri("http://localhost:8443"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> homeRouter(
            @Value("classpath:/public/index.html") Resource html) {
        return route(
                GET("/")
                , request
                        -> ok().contentType(MediaType.TEXT_HTML).syncBody(html)
        );
    }


    @Bean
    public RouterFunction<ServerResponse> groupRouter(
            @Value("classpath:/public/index.html") Resource html) {
        return route(
                GET("/groups/**")
                , request
                        -> ok().contentType(MediaType.TEXT_HTML).syncBody(html)
        );

    }

    @Bean
    public RouterFunction<ServerResponse> userRouter(
            @Value("classpath:/public/index.html") Resource html) {
        return route(
                GET("/user/**")
                , request
                        -> ok().contentType(MediaType.TEXT_HTML).syncBody(html)
        );
    }

}
