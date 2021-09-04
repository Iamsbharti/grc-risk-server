package com.grc.riskassesment.repository;

import com.grc.riskassesment.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RiskAssesmentRepository extends MongoRepository<Users, Integer> {
    List<Users> findAll();
    Users  save(Users user);
    @Query("{ 'firstname' : ?0 }")
    List<Users> findByTheUsersFirstname(String firstname);

    @Query("{ 'login' : ?0 }")
    Optional<Users> findByTheUsersLogin(String login);

}
