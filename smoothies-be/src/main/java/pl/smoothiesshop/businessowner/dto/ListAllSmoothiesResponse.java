package pl.smoothiesshop.businessowner.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ListAllSmoothiesResponse {
    @NotNull
    private List<SmoothieDto> smoothies;
    @NotNull
    private Long totalResultsCount;
}
