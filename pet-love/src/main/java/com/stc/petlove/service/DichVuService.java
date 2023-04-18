package com.stc.petlove.service;

import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.DichVuResponse;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.exception.ResourceNotFoundException;

import java.util.List;

public interface DichVuService {
    List<DichVu> getAllDichVu();

    DichVuResponse getDichVuById(String dichVuID) throws ResourceNotFoundException;

    DichVuResponse createDichVu(DichVu dichVu);

    DichVuResponse updateDichVu(String dichVuID, DichVu dichVuDetails) throws ResourceNotFoundException;

    ApiResponse deleteDichVu(String dichVuID) throws ResourceNotFoundException;
}
