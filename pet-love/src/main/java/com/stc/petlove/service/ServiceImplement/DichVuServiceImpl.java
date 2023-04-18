package com.stc.petlove.service.ServiceImplement;

import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.DichVuResponse;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.exception.BadRequestException;
import com.stc.petlove.exception.ResourceNotFoundException;
import com.stc.petlove.repository.DichVuRepo;
import com.stc.petlove.service.DichVuService;
import com.stc.petlove.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    private DichVuRepo dichVuRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<DichVu> getAllDichVu() {
        return dichVuRepo.findAll();
    }

    @Override
    public DichVuResponse getDichVuById(String dichVuID) throws ResourceNotFoundException {
        DichVu dichVu = dichVuRepo.findById(dichVuID)
                .orElseThrow(() -> new ResourceNotFoundException("DichVu", "dichVuID", dichVuID));
        return new DichVuResponse(dichVu.getId(), dichVu.getMaDichVu(), dichVu.getTenDichVu(),
                dichVu.getNoiDung(), dichVu.getGiaDichVus(), dichVu.isTrangThai());
    }

    @Override
    public DichVuResponse createDichVu(DichVu dichVu) {
        Optional<DichVu> dichVuOptional = dichVuRepo.
                findDichVuByMaDichVu(dichVu.getMaDichVu());
        if (dichVuOptional.isPresent()) {
            throw new BadRequestException("Mã dịch vụ đã tồn tại! Vui lòng nhập giá trị khác!");
        }
        dichVu.setId(String.valueOf(sequenceGeneratorService.generateSequence(dichVu.SEQUENCE_NAME)));
        dichVu.setGiaDichVus(dichVu.getGiaDichVus());
        DichVu newDichVu = dichVuRepo.save(dichVu);
        return new DichVuResponse(newDichVu.getId(), newDichVu.getMaDichVu(), newDichVu.getTenDichVu(),
                newDichVu.getNoiDung(), newDichVu.getGiaDichVus(), newDichVu.isTrangThai());
    }

    @Override
    public DichVuResponse updateDichVu(String dichVuID, DichVu dichVuDetails) throws ResourceNotFoundException {
        DichVu dichVu = dichVuRepo.findById(dichVuID)
                .orElseThrow(() -> new ResourceNotFoundException("DichVu", "dichVuID", dichVuID));

        dichVu.setMaDichVu(dichVuDetails.getMaDichVu());
        dichVu.setTenDichVu(dichVuDetails.getTenDichVu());
        dichVu.setNoiDung(dichVuDetails.getNoiDung());
        dichVu.setGiaDichVus(dichVuDetails.getGiaDichVus());
        dichVu.setTrangThai(dichVuDetails.isTrangThai());
        final DichVu updatedLoaiThuCung = dichVuRepo.save(dichVu);
        return new DichVuResponse(updatedLoaiThuCung.getId(), updatedLoaiThuCung.getMaDichVu(), updatedLoaiThuCung.getTenDichVu(),
                updatedLoaiThuCung.getNoiDung(), updatedLoaiThuCung.getGiaDichVus(), updatedLoaiThuCung.isTrangThai());
    }

    @Override
    public ApiResponse deleteDichVu(String dichVuID) throws ResourceNotFoundException {
        DichVu dichVu = dichVuRepo.findById(dichVuID)
                .orElseThrow(() -> new ResourceNotFoundException("DichVu", "dichVuID", dichVuID));

        dichVuRepo.delete(dichVu);
        return new ApiResponse(Boolean.TRUE, "DichVu deleted successfully");
    }
}
