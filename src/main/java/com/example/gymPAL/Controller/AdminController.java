package com.example.gymPAL.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymPAL.Entity.CredentialsEntity;
import com.example.gymPAL.Services.AdminService;

@RestController
public class AdminController {

    @Autowired
    AdminService as;
    
    @GetMapping("/admin/users/credentials")
    public List<CredentialsEntity> getAllCredentials() {
        return as.generateCredentialsReport();
    }

    @GetMapping("/admin/users/credential")
    public CredentialsEntity getUserCredentialsByUsername(@RequestParam String username) {
        return as.generateCredentialsReportByUsername(username);
    }

    @PostMapping("/admin/users/credential")
    public String createUserCredentials(@RequestBody CredentialsEntity entity) {
        as.createCredential(entity);
        return "created successfully";
    }


}
