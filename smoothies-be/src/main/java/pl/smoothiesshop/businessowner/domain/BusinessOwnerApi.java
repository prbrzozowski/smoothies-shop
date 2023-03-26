package pl.smoothiesshop.businessowner.domain;

import io.vavr.control.Try;
import pl.smoothiesshop.businessowner.dto.ListAllSmoothiesResponse;
import pl.smoothiesshop.businessowner.dto.SmoothieDetailDto;

public interface BusinessOwnerApi {

    Try<ListAllSmoothiesResponse> listAllSmoothies(int pageNr, int pageSize);

    Try<Void> deleteSmoothieDetails(int smoothieDetailsId);

    Try<Void> editSmoothieDetails(SmoothieDetailDto detailsDto);
}
