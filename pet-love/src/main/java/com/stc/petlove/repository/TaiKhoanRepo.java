package com.stc.petlove.repository;

import com.stc.petlove.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TaiKhoanRepo extends MongoRepository<TaiKhoan, String> {
    Optional<TaiKhoan> findTaiKhoanByEmail(String email);
}
