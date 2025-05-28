package com.jiofack.products.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Products API")
                        .version("1.0.0")
                        .description("API de gestion d'un inventaire de produits. Elle permet de créer, mettre à jour, supprimer, afficher la liste des produits et alerter sur les stocks bas")
                );
    }
}
