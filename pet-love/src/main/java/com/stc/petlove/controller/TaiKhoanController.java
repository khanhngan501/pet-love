package com.stc.petlove.controller;

import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.TaiKhoanResponse;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.exception.BadRequestException;
import com.stc.petlove.exception.ResourceNotFoundException;
import com.stc.petlove.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @GetMapping("/taiKhoans")
    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> taiKhoans = taiKhoanService.getAllTaiKhoan();
        return taiKhoans;
    }
    @GetMapping("/taiKhoans/{id}")
    public ResponseEntity<TaiKhoanResponse> getTaiKhoanById(@PathVariable(value = "id") String taiKhoanID) throws ResourceNotFoundException {
        TaiKhoanResponse taiKhoanResponse = taiKhoanService.getTaiKhoanById(taiKhoanID);
        return new ResponseEntity<>(taiKhoanResponse, HttpStatus.OK);
    }

    @PostMapping("/taiKhoans")
    public ResponseEntity<TaiKhoanResponse> createTaiKhoan(@Valid @RequestBody TaiKhoan taiKhoan) throws BadRequestException {
        TaiKhoanResponse taiKhoanResponse = taiKhoanService.createTaiKhoan(taiKhoan);
        return new ResponseEntity<>(taiKhoanResponse, HttpStatus.OK);
    }

    @PutMapping("/taiKhoans/{id}")
    public ResponseEntity<TaiKhoanResponse> updateTaiKhoan(@PathVariable(value = "id") String taiKhoanID,
                                                                 @Valid @RequestBody TaiKhoan taiKhoanDetails) throws ResourceNotFoundException {
        TaiKhoanResponse taiKhoanResponse = taiKhoanService.updateTaiKhoan(taiKhoanID, taiKhoanDetails);
        return new ResponseEntity<>(taiKhoanResponse, HttpStatus.OK);
    }

    @DeleteMapping("/taiKhoans/{id}")
    public ResponseEntity<ApiResponse> deleteTaiKhoan(@PathVariable(value = "id") String taiKhoanID)
            throws ResourceNotFoundException {
        ApiResponse apiResponse = taiKhoanService.deleteTaiKhoan(taiKhoanID);
        return new ResponseEntity< >(apiResponse, HttpStatus.OK);
    }
}
