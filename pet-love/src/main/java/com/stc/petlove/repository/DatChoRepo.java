package com.stc.petlove.repository;

import com.stc.petlove.entities.DatCho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatChoRepo extends MongoRepository<DatCho, String> {

}
