package gateway.infra;


import java.util.function.Function;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleRoute {

    @Bean
    public RouteLocator sample(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bypath", r -> r.path("/header")
                        .filters(f -> f.addRequestHeader("Book", "1.Spring 5.0 By Example"))
                        .uri("http://httpbin.org:80"))
                .route("add-query-param", r -> r.path("/get")
                        .filters(f -> f.addRequestHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huQGdtYWlsLmNvbSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJuYW1lIjoiSm9obiIsImlkIjoiMSIsImV4cCI6MTU5MTgxNTIxNiwidXNlck5hbWUiOiJqb2huQGdtYWlsLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfQ1JFQVRFX05PVEUiLCJST0xFX1ZJRVdfTk9URSIsIlJPTEVfRURJVF9OT1RFIiwiUk9MRV9ERUxFVEVfTk9URSIsIlJPTEVfVklFV19BTExfTk9URSJdLCJqdGkiOiJjNDlmN2FjNS1kNWYyLTRiNzMtYTRkNy0xN2MxOGYyOWI0MDciLCJjbGllbnRfaWQiOiJ0YWxrMmFtYXJlc3dhcmFuIn0.Y8_-6qPfn1rKHGK1uhrd_ennkrne1PPljHPQ-kbD2XSujsHhyRQMMLecn994zRk6oBWXmGSrZWarFuETEYXfp2y1lQ9_b8obGiGJCZPdmgHyCso_o93qiKSxeMAwtP90RB6RvPdYDfdcQrISpS_heotcGmrTvUVs2gOVxRsrU-lvyITWiMhfhumcm-bgJ157QLAlQLH16Xbq4sYuq_nyfqSZe16-KoEaY7woGe62cOqQNlpcWFeSbg1pFIeLvUxTVdiWhSEcH8nJCUYhmtu4ZehyJg73-YnYg_mNCJBTXKwX-2DLD2I08SutGl3S2CpQsdHQR3WYFWMBxPwyFo_3wQ"))

                        .uri("http://httpbin.org:80"))
                .route("add-jwt-token", r -> r.path("/api/**")
                        .filters(f -> f.addRequestHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huQGdtYWlsLmNvbSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJuYW1lIjoiSm9obiIsImlkIjoiMSIsImV4cCI6MTU5MTgxNTIxNiwidXNlck5hbWUiOiJqb2huQGdtYWlsLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfQ1JFQVRFX05PVEUiLCJST0xFX1ZJRVdfTk9URSIsIlJPTEVfRURJVF9OT1RFIiwiUk9MRV9ERUxFVEVfTk9URSIsIlJPTEVfVklFV19BTExfTk9URSJdLCJqdGkiOiJjNDlmN2FjNS1kNWYyLTRiNzMtYTRkNy0xN2MxOGYyOWI0MDciLCJjbGllbnRfaWQiOiJ0YWxrMmFtYXJlc3dhcmFuIn0.Y8_-6qPfn1rKHGK1uhrd_ennkrne1PPljHPQ-kbD2XSujsHhyRQMMLecn994zRk6oBWXmGSrZWarFuETEYXfp2y1lQ9_b8obGiGJCZPdmgHyCso_o93qiKSxeMAwtP90RB6RvPdYDfdcQrISpS_heotcGmrTvUVs2gOVxRsrU-lvyITWiMhfhumcm-bgJ157QLAlQLH16Xbq4sYuq_nyfqSZe16-KoEaY7woGe62cOqQNlpcWFeSbg1pFIeLvUxTVdiWhSEcH8nJCUYhmtu4ZehyJg73-YnYg_mNCJBTXKwX-2DLD2I08SutGl3S2CpQsdHQR3WYFWMBxPwyFo_3wQ"))
                        .uri("http://localhost:8443"))
                .route("response-headers", (r) -> r.path("/response-headers")
                        .filters(f -> f.addRequestHeader("book", "3.spring5.0"))
                        .uri("http://httpbin.org:80"))
                .route("combine-and-change", (r) -> r.path("/anything").and().header("access-key", "AAA")
                        .filters(f -> f.addRequestHeader("access-key", "4.BBB"))
                        .uri("http://httpbin.org:80"))
                .build();
    }

}