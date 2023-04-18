package com.stc.petlove.repository;

import com.stc.petlove.entities.LoaiThuCung;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoaiThuCungRepo extends MongoRepository<LoaiThuCung, String> {
    Optional<LoaiThuCung> findLoaiThuCungByMaLoaiThuCung(String maLoaiThuCung);
}
