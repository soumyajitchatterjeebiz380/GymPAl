package com.example.gymPAL.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymPAL.Entity.GymPalEntity;
import com.example.gymPAL.Services.GymPalService;

@RestController
public class GymPalController {
    @Autowired
    GymPalService gps;

    @PostMapping("/profile/member")
    public String createUser(@RequestBody GymPalEntity ge) {
        gps.createUser(ge);
        return "Created Successfully";
    }

    @GetMapping("/profile/members")
    public List<GymPalEntity> getAllUsers(@PathVariable int id) {
        return gps.getAllUsers(id);
    }

    @GetMapping("/")
    public String returnHomePage() {
        return "Welcome To GymPAl API";
    }

    @GetMapping("/profile/member/{id}/{chosenDay}")
    public List<GymPalEntity> filterUsersByChosenDay(@PathVariable int id, @PathVariable String chosenDay) {
        return gps.filterUsersByChosenDay(chosenDay,id);
    }

    @GetMapping("/profile/member")
    public List<GymPalEntity> filterUsersByAge(@RequestParam int id, @RequestParam int low, @RequestParam int high) {
        return gps.filterUsersByAge(id, low, high);
    }

    @PutMapping("/profile/managment")
    public String updateUser(@RequestBody GymPalEntity ge) {
        return gps.updateUser(ge);
    }

    @DeleteMapping("/profile/managment")
    public String deleteUser(@RequestParam int id) {
        return gps.deleteUser(id);
    }


    
    

}
