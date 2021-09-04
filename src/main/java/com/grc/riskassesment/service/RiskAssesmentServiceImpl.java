package com.grc.riskassesment.service;

import com.grc.riskassesment.common.ApiResponse;
import com.grc.riskassesment.models.Risks;
import com.grc.riskassesment.models.Users;
import com.grc.riskassesment.repository.RiskAssesmentRepository;
import com.grc.riskassesment.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public ApiResponse userLogin(String loginId, String password) {
        Optional<Users> user = riskAssesmentRepository.findByTheUsersLogin(loginId);
        if(user.isPresent()){
            if(user.get().getPassword().equalsIgnoreCase(password)){
                // get all the associated risk
                List<Risks> risks = riskRepository.findAll();
                List assecedRisks  = risks
                        .stream()
                        .filter(risk -> risk.getAssessors().contains(loginId))
                        .collect(Collectors.toList());
                user.get().setAllowedRiskAccess(assecedRisks);
                user.get().setPassword("");
                return new  ApiResponse("200","User Login Success",user);
            }else{
                return new ApiResponse("401","Login failed",loginId);
            }
        }else{
            return new ApiResponse("404","User Not Found",loginId);
        }
    }
}
