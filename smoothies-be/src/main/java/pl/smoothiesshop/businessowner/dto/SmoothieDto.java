package pl.smoothiesshop.businessowner.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SmoothieDto {
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private List<SmoothieDetailDto> smoothieDetails;
}
