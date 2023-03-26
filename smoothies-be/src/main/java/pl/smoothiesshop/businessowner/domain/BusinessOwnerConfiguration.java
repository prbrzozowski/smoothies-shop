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


    //TODO move it to some other place
    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        // TODO może trzeba to wyrzucić bo i tak nie działa
        modelMapper.registerModule(new VavrModule());
        return modelMapper;
    }

    //TODO move it to some other place
    @Bean
    io.vavr.jackson.datatype.VavrModule vavrModule() {
        return new io.vavr.jackson.datatype.VavrModule();
    }
}
