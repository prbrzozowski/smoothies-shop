package pl.smoothiesshop.businessowner.dto;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ListAllSmoothiesResponse {
    private List<SmoothieDto> smoothies;
    private long totalResultsCount;
}
