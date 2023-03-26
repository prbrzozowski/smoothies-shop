package pl.smoothiesshop.businessowner.domain;

import io.vavr.collection.List;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import pl.smoothiesshop.businessowner.dto.ListAllSmoothiesResponse;
import pl.smoothiesshop.businessowner.dto.SmoothieDetailDto;
import pl.smoothiesshop.businessowner.dto.SmoothieDto;
import pl.smoothiesshop.repository.Smoothie;
import pl.smoothiesshop.repository.SmoothieDetail;
import pl.smoothiesshop.repository.SmoothieDetailsRepository;
import pl.smoothiesshop.repository.SmoothiesRepository;

import java.util.Optional;


@AllArgsConstructor
public class BusinessOwnerFacade implements BusinessOwnerApi {
    private final SmoothiesRepository smoothiesRepository;
    private final SmoothieDetailsRepository smoothieDetailsRepository;
    private final ModelMapper modelMapper;


    //TODO pagination


    @Override
    @Transactional
    public Try<ListAllSmoothiesResponse> listAllSmoothies(int page, int pageSize) {
        return Try.of(() -> {
            final PageRequest pageRequest = PageRequest.of(page,pageSize, Sort.by("name"));
            final Page<Smoothie> smoothiesRepositoryAll = smoothiesRepository.findAll(pageRequest);
            final List<Smoothie> smoothies = List.ofAll(smoothiesRepositoryAll);
            return ListAllSmoothiesResponse.builder()
                    .totalResultsCount(smoothiesRepositoryAll.getTotalElements())
                    .smoothies(smoothies
                            .map(smoothie -> modelMapper.map(smoothie, SmoothieDto.class))
                            .collect(List.collector()))
                    .build();
        });
    }

    @Transactional
    @Override
    public Try<Void> deleteSmoothieDetails(int smoothieDetailsId) {
        return Try.run(() -> {
            smoothieDetailsRepository.deleteAllByIdInBatch(List.of(smoothieDetailsId));
        });
    }

    @Transactional
    @Override
    public Try<Void> editSmoothieDetails(SmoothieDetailDto detailsDto) {
        return Try.run(() -> {
            final Optional<SmoothieDetail> smoothieDetailOpt = smoothieDetailsRepository.findById(detailsDto.getId());
            smoothieDetailOpt.ifPresent(smoothieDetail -> {
                smoothieDetail.setName(detailsDto.getName());
                smoothieDetail.setDescription(detailsDto.getDescription());
                smoothieDetailsRepository.save(smoothieDetail);
            });
        });
    }
}
