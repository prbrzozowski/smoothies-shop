package pl.smoothiesshop.businessowner.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SmoothieDetailDto {
    private int id;
    private String name;
    private String description;
}
