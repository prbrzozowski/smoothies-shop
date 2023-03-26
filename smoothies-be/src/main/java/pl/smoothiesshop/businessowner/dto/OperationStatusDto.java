package pl.smoothiesshop.businessowner.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OperationStatusDto {
    @NotNull
    private Status status;

    public enum Status {
        SUCCESS,
        ERROR
    }
}
