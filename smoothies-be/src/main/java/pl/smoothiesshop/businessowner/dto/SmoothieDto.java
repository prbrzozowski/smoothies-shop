package pl.smoothiesshop.businessowner.dto;


import lombok.*;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SmoothieDto {
    private int id;
    private String name;
    private List<SmoothieDetailDto> smoothieDetails;
}
