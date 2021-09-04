package com.grc.riskassesment.service;

import com.grc.riskassesment.models.Risks;
import com.grc.riskassesment.models.Users;
import com.grc.riskassesment.repository.RiskAssesmentRepository;
import com.grc.riskassesment.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssesmentServiceImpl extends RiskAssesmentService {
    @Autowired
    RiskAssesmentRepository riskAssesmentRepository;

    @Autowired
    RiskRepository riskRepository;
    @Override
    public List<Users> getAllUsersService() {
        return riskAssesmentRepository.findAll();
    }

    @Override
    public Users saveUser(Users user) {
        return riskAssesmentRepository.save(user);
    }

    @Override
    public List<Users> getUserByFirstname(String first_name) {
        return  riskAssesmentRepository.findByTheUsersFirstname(first_name);
    }

    @Override
    public List<Risks> getAllRisksService() {
        return riskRepository.findAll();
    }

    @Override
    public Risks saveRisk(Risks risk) {
        return riskRepository.save(risk);
    }

    @Override
    public List<Risks> getRiskById(Integer id) {
        return riskRepository.getById(id);
    }
}
