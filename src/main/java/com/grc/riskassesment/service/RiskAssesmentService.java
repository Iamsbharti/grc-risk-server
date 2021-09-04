package com.grc.riskassesment.service;

import com.grc.riskassesment.common.ApiResponse;
import com.grc.riskassesment.models.Risks;
import com.grc.riskassesment.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class RiskAssesmentService {
    public abstract List<Users> getAllUsersService();
    public abstract Users saveUser(Users User);
    public abstract List<Users> getUserByFirstname(String first_name);

    public abstract List<Risks> getAllRisksService();
    public abstract Risks saveRisk(Risks risk);
    public abstract List<Risks> getRiskById(Integer id);

    public abstract ApiResponse userLogin(String loginId ,String password);


}
