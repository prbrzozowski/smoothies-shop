package pl.smoothiesshop.infrastructure;

import com.github.julianps.modelmapper.VavrModule;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.registerModule(new VavrModule());
        return modelMapper;
    }

    @Bean
    io.vavr.jackson.datatype.VavrModule vavrModule() {
        return new io.vavr.jackson.datatype.VavrModule();
    }

}
