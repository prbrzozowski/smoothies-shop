package pl.smoothiesshop.businessowner;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.smoothiesshop.businessowner.domain.BusinessOwnerApi;
import pl.smoothiesshop.businessowner.dto.ListAllSmoothiesResponse;
import pl.smoothiesshop.businessowner.dto.OperationStatusDto;
import pl.smoothiesshop.businessowner.dto.SmoothieDetailDto;

@RestController()
@AllArgsConstructor
public class BusinessOwnerController {
    private final BusinessOwnerApi businessOwnerApi;


    @Operation(summary = "List smoothies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Got the smoothies",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ListAllSmoothiesResponse.class))})})
    @GetMapping(path = "/api/business/smoothies/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListAllSmoothiesResponse> listSmoothies(@RequestParam(name = "page") int page,
                                                                  @RequestParam(name = "pageSize") int pageSize) {
        final ListAllSmoothiesResponse listAllSmoothies = businessOwnerApi.listAllSmoothies(page, pageSize)
                .getOrElseThrow(ex -> new RuntimeException("TODO", ex));
        return ResponseEntity.ok(listAllSmoothies);
    }

    @PostMapping(path = "/api/business/smoothies/details/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperationStatusDto> editSmoothies(SmoothieDetailDto smoothieDetailDto) {
        businessOwnerApi.editSmoothieDetails(smoothieDetailDto)
                .getOrElseThrow(ex -> new RuntimeException("TODO", ex));
        return ResponseEntity.ok(OperationStatusDto.builder()
                .status(OperationStatusDto.Status.SUCCESS).build());
    }

    @DeleteMapping(path = "/api/business/smoothies/details/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperationStatusDto> deleteSmoothiesDetails(@PathVariable("id") int smoothieDetailsId) {
        businessOwnerApi.deleteSmoothieDetails(smoothieDetailsId)
                .getOrElseThrow(ex -> new RuntimeException("TODO", ex));
        return ResponseEntity.ok(OperationStatusDto.builder()
                .status(OperationStatusDto.Status.SUCCESS).build());

    }
}
