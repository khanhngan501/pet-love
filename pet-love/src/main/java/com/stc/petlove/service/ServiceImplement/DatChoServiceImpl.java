package com.stc.petlove.service.ServiceImplement;

import com.stc.petlove.dto.responseDTO.ApiResponse;
import com.stc.petlove.dto.responseDTO.DatChoResponse;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.exception.ResourceNotFoundException;
import com.stc.petlove.repository.DatChoRepo;
import com.stc.petlove.service.DatChoService;
import com.stc.petlove.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatChoServiceImpl implements DatChoService {
    @Autowired
    private DatChoRepo datChoRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public List<DatCho> getAllDatCho() {
        return datChoRepo.findAll();
    }

    @Override
    public DatChoResponse getDatChoById(String datChoID) throws ResourceNotFoundException {
        DatCho datCho = datChoRepo.findById(datChoID)
                .orElseThrow(() -> new ResourceNotFoundException("DatCho", "datChoID", datChoID));
        return new DatChoResponse(datCho.getId(), datCho.getEmail(), datCho.getThongTinDatChos(),
                datCho.getThoiGian(), datCho.getCanDan(), datCho.getTrangThaiDatCho(), datCho.isTrangThai());
    }

    @Override
    public DatChoResponse createDatCho(DatCho datCho) {
        datCho.setId(String.valueOf(sequenceGeneratorService.generateSequence(datCho.SEQUENCE_NAME)));
        DatCho newDatCho = datChoRepo.save(datCho);
        return new DatChoResponse(datCho.getId(), datCho.getEmail(), datCho.getThongTinDatChos(),
                datCho.getThoiGian(), datCho.getCanDan(), datCho.getTrangThaiDatCho(), datCho.isTrangThai());
    }

    @Override
    public DatChoResponse updateDatCho(String datChoID, DatCho datChoDetails) throws ResourceNotFoundException {
        DatCho datCho = datChoRepo.findById(datChoID)
                .orElseThrow(() -> new ResourceNotFoundException("DatCho", "datChoID", datChoID));

        datCho.setEmail(datChoDetails.getEmail());
        datCho.setThongTinDatChos(datChoDetails.getThongTinDatChos());
        datCho.setThoiGian(datChoDetails.getThoiGian());
        datCho.setCanDan(datChoDetails.getCanDan());
        datCho.setTrangThaiDatCho(datChoDetails.getTrangThaiDatCho());
        datCho.setTrangThai(datChoDetails.isTrangThai());
        final DatCho updatedDatCho = datChoRepo.save(datCho);
        return new DatChoResponse(datCho.getId(), datCho.getEmail(), datCho.getThongTinDatChos(),
                datCho.getThoiGian(), datCho.getCanDan(), datCho.getTrangThaiDatCho(), datCho.isTrangThai());
    }

    @Override
    public ApiResponse deleteDatCho(String datChoID) throws ResourceNotFoundException {
        DatCho datCho = datChoRepo.findById(datChoID)
                .orElseThrow(() -> new ResourceNotFoundException("DatCho", "datChoID", datChoID));

        datChoRepo.delete(datCho);
        return new ApiResponse(Boolean.TRUE, "DatCho deleted successfully");
    }
}
