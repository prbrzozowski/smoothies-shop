package pl.smoothiesshop.customer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Bean
    CustomerApi customerApi() {
        return new CustomerFacade();
    }

}
