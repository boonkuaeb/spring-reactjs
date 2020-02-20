package gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
