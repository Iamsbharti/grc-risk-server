package com.grc.riskassesment.repository;

import com.grc.riskassesment.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RiskAssesmentRepository extends MongoRepository<Users, Integer> {
    List<Users> findAll();
    Users  save(Users user);
    @Query("{ 'firstname' : ?0 ,collation = \"en_US\"}")
    List<Users> findByTheUsersFirstname(String firstname);

}
