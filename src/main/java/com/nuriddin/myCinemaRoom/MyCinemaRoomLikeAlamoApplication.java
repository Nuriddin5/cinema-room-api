package com.nuriddin.myCinemaRoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
// /swagger-ui/index.html#/ go to for swagger
public class MyCinemaRoomLikeAlamoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyCinemaRoomLikeAlamoApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.nuriddin.My-Cinema-Room")).build();
    }

}
