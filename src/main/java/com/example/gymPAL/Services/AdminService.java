package com.example.gymPAL.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymPAL.Entity.CredentialsEntity;
import com.example.gymPAL.Repository.AdminRepo;

@Service
public class AdminService {
    @Autowired
    AdminRepo ar;

    public List<CredentialsEntity> generateCredentialsReport() {
        List<CredentialsEntity> records = new ArrayList<>();
        ar.findAll().forEach(
            entity ->records.add(entity) 
        );
        return records;
    }

    public CredentialsEntity generateCredentialsReportByUsername(String username){

        List<CredentialsEntity> records = generateCredentialsReport();
        for(CredentialsEntity record : records) {
            if(record.getUsername().equals(username)) return record;
        }

        return null;

    }

    public void createCredential(CredentialsEntity entity) {
        ar.save(entity);
    }
    
}
