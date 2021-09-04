package com.grc.riskassesment.controller;


import com.grc.riskassesment.common.ApiResponse;
import com.grc.riskassesment.models.Risks;
import com.grc.riskassesment.models.Users;
import com.grc.riskassesment.service.RiskAssesmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/risk")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RiskAssesmentController {
    @Autowired
    RiskAssesmentService riskAssesmentService;

    @GetMapping("/health")
    public ApiResponse serverHealth(){
        ApiResponse apiResponse = new ApiResponse("200","Server-UP",null);
        return apiResponse;
    }
    @GetMapping("/users")
    public ApiResponse getUsers(){
        List<Users> users = riskAssesmentService.getAllUsersService();
        ApiResponse response = new ApiResponse("200","Users Fetched",users);
        return response;
    }
    @GetMapping("/user")
    public ApiResponse getUserByName(@RequestParam(value = "first_name") String first_name){
        List<Users> users = riskAssesmentService.getUserByFirstname(first_name);
        ApiResponse response = new ApiResponse("200","Users Fetched",users);
        return response;
    }

    @PostMapping("/users")
    public ApiResponse saveUser(@RequestBody Users user){
        Users newUser = riskAssesmentService.saveUser(user);
        return new ApiResponse("200","User Saved",newUser);
    }

    @GetMapping("/risks")
    public ApiResponse getRisks(){
        List<Risks> allRisks = riskAssesmentService.getAllRisksService();
        ApiResponse response = new ApiResponse("200","Risks Fetched",allRisks);
        return response;
    }
    @PostMapping("/risks")
    public ApiResponse saveRisk(@RequestBody Risks risk){
        Risks newRisk = riskAssesmentService.saveRisk(risk);
        return new ApiResponse("200","Risk Saved",newRisk);
    }
    @PostMapping("/login")
    public ApiResponse login(@RequestParam String loginId,@RequestParam String password){
        return riskAssesmentService.userLogin(loginId,password);
    }


}
