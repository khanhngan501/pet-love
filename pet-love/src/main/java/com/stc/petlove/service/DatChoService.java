package com.stc.petlove.service;


import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.DatChoResponse;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.exception.ResourceNotFoundException;

import java.util.List;

public interface DatChoService {
    List<DatCho> getAllDatCho();

    DatChoResponse getDatChoById(String datChoID) throws ResourceNotFoundException;

    DatChoResponse createDatCho(DatCho datCho);

    DatChoResponse updateDatCho(String datChoID, DatCho datChoDetails) throws ResourceNotFoundException;

    ApiResponse deleteDatCho(String datChoID) throws ResourceNotFoundException;
}
