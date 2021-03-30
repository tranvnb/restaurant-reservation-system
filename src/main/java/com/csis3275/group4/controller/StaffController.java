package com.csis3275.group4.controller;

import com.csis3275.group4.repository.StaffRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {
    private StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping("/staff")
    public String showStaff(Model model){
        model.addAttribute("staffList", staffRepository.findAll());
        return "staff_display";
    }
}
