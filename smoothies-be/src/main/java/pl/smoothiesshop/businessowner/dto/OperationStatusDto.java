package pl.smoothiesshop.businessowner.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OperationStatusDto {
    private Status status;

    public enum Status {
        SUCCESS,
        ERROR
    }
}
