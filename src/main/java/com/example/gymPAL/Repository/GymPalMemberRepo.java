package com.example.gymPAL.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gymPAL.Entity.GymPalEntity;

@Repository
public interface GymPalMemberRepo  extends JpaRepository<GymPalEntity, Integer>{
    
}
