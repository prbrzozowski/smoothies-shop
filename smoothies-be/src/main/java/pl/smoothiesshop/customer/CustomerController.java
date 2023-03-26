package pl.smoothiesshop.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/api/customer/smooties/list")
    public String listSmoothies(@RequestBody String input) {
        return "Hello World from Spring Boot";
    }

}
