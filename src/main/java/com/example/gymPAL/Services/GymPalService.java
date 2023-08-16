package com.example.gymPAL.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymPAL.Entity.GymPalEntity;
import com.example.gymPAL.Repository.GymPalMemberRepo;

@Service
public class GymPalService {
    @Autowired
    GymPalMemberRepo gpr;

    public void createUser(GymPalEntity ge) {
        gpr.save(ge);
    }
    
    public List<GymPalEntity> getAllUsers(int id) {
        List<GymPalEntity> records =   generateAllGYMPAls(id);
         List<GymPalEntity> filtered = new ArrayList<>();
        for(GymPalEntity record : records) {
            if(id != record.getId()) {
                filtered.add(record);
            }
        }
        return filtered;
    }

    public List<GymPalEntity> filterUsersByChosenDay(String Day, int id) {
        List<GymPalEntity> records =   generateAllGYMPAls(id);
        List<GymPalEntity> filtered = new ArrayList<>();
        for(GymPalEntity record : records) {
            if(Day.equals(record.getAvailable_time()) & id != record.getId()) {
                filtered.add(record);
            }
        }
        return filtered;
    }

    public List<GymPalEntity> filterUsersByAge(int id, int low, int high) {
        List<GymPalEntity> records =  generateAllGYMPAls(id);
        List<GymPalEntity> filter = new ArrayList<>();
        for(GymPalEntity record : records) {
            if(record.getAge() >= low && record.getAge() <= high) filter.add(record);
        }
        return filter;
    }

    private List<GymPalEntity> generateAllGYMPAls(int id) {
        List<GymPalEntity> records =  new ArrayList<>();
        gpr.findAll().forEach(entity -> records.add(entity));
        return records;
    }

    public String updateUser(GymPalEntity gpe) {
       GymPalEntity record =  gpr.findById(gpe.getId()).orElse(null);
       if(record == null ) return "Oh no! GympPal Not Found";
       gpr.save(gpe);
       return "Successfully updated record";
    }

    public String deleteUser(int id) {
        GymPalEntity record =  gpr.findById(id).orElse(null);
        if(record == null ) return "Oh no! GympPal Not Found";
        gpr.deleteById(id);
        return "Successfully deleted";
    }
}
