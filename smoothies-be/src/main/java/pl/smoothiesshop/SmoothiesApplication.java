package pl.smoothiesshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Smoothies API", version = "2.0", description = "Smoothies Shop API"))
public class SmoothiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmoothiesApplication.class, args);
    }
}

