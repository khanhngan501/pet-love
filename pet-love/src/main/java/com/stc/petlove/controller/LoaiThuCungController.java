package com.stc.petlove.controller;

import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.exception.BadRequestException;
import com.stc.petlove.exception.ResourceNotFoundException;
import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.LoaiThuCungResponse;
import com.stc.petlove.service.LoaiThuCungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class LoaiThuCungController {
    @Autowired
    private LoaiThuCungService loaiThuCungService;

    @GetMapping("/loaiThuCungs")
    public List<LoaiThuCung> getAllLoaiThuCung() {
        List<LoaiThuCung> loaiThuCungs = loaiThuCungService.getAllLoaiThuCung();
        return loaiThuCungs;
    }

    @GetMapping("/loaiThuCung/{id}")
    public ResponseEntity<LoaiThuCungResponse> getLoaiThuCungsById(@PathVariable(value = "id") String loaiThuCungID) throws ResourceNotFoundException {
        LoaiThuCungResponse loaiThuCung = loaiThuCungService.getLoaiThuCungsById(loaiThuCungID);
        return new ResponseEntity<>(loaiThuCung, HttpStatus.OK);
    }

    @PostMapping("/loaiThuCung")
    public ResponseEntity<LoaiThuCungResponse> createLoaiThuCungs(@Valid @RequestBody LoaiThuCung loaiThuCung) throws BadRequestException {
        LoaiThuCungResponse loaiThuCungResponse = loaiThuCungService.createLoaiThuCungs(loaiThuCung);
        return new ResponseEntity<>(loaiThuCungResponse, HttpStatus.OK);
    }

    @PutMapping("/loaiThuCung/{id}")
    public ResponseEntity<LoaiThuCungResponse> updateLoaiThuCung(@PathVariable(value = "id") String loaiThuCungID,
                                                   @Valid @RequestBody LoaiThuCung loaiThuCungDetails) throws ResourceNotFoundException {
        LoaiThuCungResponse loaiThuCungResponse = loaiThuCungService.updateLoaiThuCung(loaiThuCungID, loaiThuCungDetails);
        return new ResponseEntity<>(loaiThuCungResponse, HttpStatus.OK);
    }

    @DeleteMapping("/loaiThuCung/{id}")
    public ResponseEntity<ApiResponse> deleteLoaiThuCungs(@PathVariable(value = "id") String loaiThuCungID)
            throws ResourceNotFoundException {
        ApiResponse apiResponse = loaiThuCungService.deleteLoaiThuCung(loaiThuCungID);
        return new ResponseEntity< >(apiResponse, HttpStatus.OK);
    }

}
