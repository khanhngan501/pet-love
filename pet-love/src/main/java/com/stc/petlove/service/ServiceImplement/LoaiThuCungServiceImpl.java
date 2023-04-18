package com.stc.petlove.service.ServiceImplement;

import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.exception.BadRequestException;
import com.stc.petlove.exception.ResourceNotFoundException;
import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.LoaiThuCungResponse;
import com.stc.petlove.repository.LoaiThuCungRepo;
import com.stc.petlove.service.LoaiThuCungService;
import com.stc.petlove.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiThuCungServiceImpl implements LoaiThuCungService {
    @Autowired
    private LoaiThuCungRepo loaiThuCungRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public List<LoaiThuCung> getAllLoaiThuCung() {
        return loaiThuCungRepo.findAll();
    }

    @Override
    public LoaiThuCungResponse getLoaiThuCungsById(String loaiThuCungID) throws ResourceNotFoundException {
        LoaiThuCung loaiThuCung = loaiThuCungRepo.findById(loaiThuCungID)
                .orElseThrow(() -> new ResourceNotFoundException("LoaiThuCung", "loaiThuCungID", loaiThuCungID));
        return new LoaiThuCungResponse(loaiThuCung.getId(), loaiThuCung.getMaLoaiThuCung(),
                loaiThuCung.getTenLoaiThuCung(), loaiThuCung.isTrangThai());
    }

    @Override
    public LoaiThuCungResponse createLoaiThuCungs(LoaiThuCung loaiThuCung) {
        Optional<LoaiThuCung> loaiThuCungByMaLoaiThuCung = loaiThuCungRepo.
                findLoaiThuCungByMaLoaiThuCung(loaiThuCung.getMaLoaiThuCung());
        if (loaiThuCungByMaLoaiThuCung.isPresent()) {
            throw new BadRequestException("Mã Loại Thủ Cưng đã tồn tại! Vui lòng nhập giá trị khác!");
        }
        loaiThuCung.setId(String.valueOf(sequenceGeneratorService.generateSequence(LoaiThuCung.SEQUENCE_NAME)));
        LoaiThuCung newLoaiThuCung = loaiThuCungRepo.save(loaiThuCung);
        return new LoaiThuCungResponse(newLoaiThuCung.getId(), newLoaiThuCung.getMaLoaiThuCung(),
                newLoaiThuCung.getTenLoaiThuCung(), newLoaiThuCung.isTrangThai());
    }

    @Override
    public LoaiThuCungResponse updateLoaiThuCung(String loaiThuCungID, LoaiThuCung loaiThuCungDetails) throws ResourceNotFoundException {
        LoaiThuCung loaiThuCung = loaiThuCungRepo.findById(loaiThuCungID)
                .orElseThrow(() -> new ResourceNotFoundException("LoaiThuCung", "loaiThuCungID", loaiThuCungID));

        loaiThuCung.setMaLoaiThuCung(loaiThuCungDetails.getMaLoaiThuCung());
        loaiThuCung.setTenLoaiThuCung(loaiThuCungDetails.getTenLoaiThuCung());
        loaiThuCung.setTrangThai(loaiThuCungDetails.isTrangThai());
        final LoaiThuCung updatedLoaiThuCung = loaiThuCungRepo.save(loaiThuCung);
        return new LoaiThuCungResponse(updatedLoaiThuCung.getId(), updatedLoaiThuCung.getMaLoaiThuCung(),
                updatedLoaiThuCung.getTenLoaiThuCung(), updatedLoaiThuCung.isTrangThai());
    }

    @Override
    public ApiResponse deleteLoaiThuCung(String loaiThuCungID) throws ResourceNotFoundException {
        LoaiThuCung loaiThuCung = loaiThuCungRepo.findById(loaiThuCungID)
                .orElseThrow(() -> new ResourceNotFoundException("LoaiThuCung", "loaiThuCungID", loaiThuCungID));

        loaiThuCungRepo.delete(loaiThuCung);
        return new ApiResponse(Boolean.TRUE, "LoaiThuCung deleted successfully");
    }
}
