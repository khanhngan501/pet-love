package com.stc.petlove.service;

import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.TaiKhoanResponse;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.exception.ResourceNotFoundException;

import java.util.List;

public interface TaiKhoanService {
    List<TaiKhoan> getAllTaiKhoan();

    TaiKhoanResponse getTaiKhoanById(String taiKhoanID) throws ResourceNotFoundException;

    TaiKhoanResponse createTaiKhoan(TaiKhoan taiKhoan);

    TaiKhoanResponse updateTaiKhoan(String taiKhoanID, TaiKhoan taiKhoanDetails) throws ResourceNotFoundException;

    ApiResponse deleteTaiKhoan(String taiKhoanID) throws ResourceNotFoundException;
}
