package pl.smoothiesshop.businessowner.domain;


import com.github.julianps.modelmapper.VavrModule;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.smoothiesshop.repository.SmoothieDetailsRepository;
import pl.smoothiesshop.repository.SmoothiesRepository;

@Configuration
public class BusinessOwnerConfiguration {

    @Bean
    BusinessOwnerApi businessOwnerApi(SmoothiesRepository smoothiesRepository,
                                      SmoothieDetailsRepository smoothieDetailsRepository,
                                      ModelMapper modelMapper) {
        return new BusinessOwnerFacade(smoothiesRepository, smoothieDetailsRepository, modelMapper);
    }

}
