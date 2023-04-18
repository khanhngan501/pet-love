package com.stc.petlove.service;

import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.exception.ResourceNotFoundException;
import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.LoaiThuCungResponse;


import java.util.List;

public interface LoaiThuCungService {
    List<LoaiThuCung> getAllLoaiThuCung();

   LoaiThuCungResponse getLoaiThuCungsById(String loaiThuCungID) throws ResourceNotFoundException;

    LoaiThuCungResponse createLoaiThuCungs(LoaiThuCung loaiThuCung);

    LoaiThuCungResponse updateLoaiThuCung(String loaiThuCungID, LoaiThuCung loaiThuCungDetails) throws ResourceNotFoundException;

    ApiResponse deleteLoaiThuCung(String loaiThuCungID) throws ResourceNotFoundException;
}
