package com.stc.petlove.repository;

import com.stc.petlove.entities.DichVu;
import com.stc.petlove.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DichVuRepo extends MongoRepository<DichVu, String> {
    Optional<DichVu> findDichVuByMaDichVu(String maDichVu);
}
