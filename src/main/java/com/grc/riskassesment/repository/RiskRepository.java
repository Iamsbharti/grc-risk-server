package com.grc.riskassesment.repository;

import com.grc.riskassesment.models.Risks;
import com.grc.riskassesment.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiskRepository extends MongoRepository<Risks,Integer> {
    List<Risks> findAll();
    Risks save(Risks risk);
    List<Risks> getById(Integer id);
}
