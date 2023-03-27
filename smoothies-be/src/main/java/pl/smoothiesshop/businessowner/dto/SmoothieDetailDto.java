package pl.smoothiesshop.businessowner.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SmoothieDetailDto {
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String description;
}
