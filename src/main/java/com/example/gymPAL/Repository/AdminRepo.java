package com.example.gymPAL.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymPAL.Entity.CredentialsEntity;

public interface AdminRepo extends JpaRepository<CredentialsEntity, Integer > {

}
