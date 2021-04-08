package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Staff;
import com.csis3275.group4.repository.StaffRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class StaffController {
    private StaffRepository staffRepository;



    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @PostMapping("/staffdashboard")
    public String staffDashboard() {
        return "redirect:/checkuser/staff_dashboard";
    }

    @GetMapping("/staff")
    public String showStaff(Model model){
        model.addAttribute("staffList", staffRepository.findAll());
        return "staff_display";
    }

    @GetMapping("/createStaff")
    public String createStaff(Model model){
        Staff staff = new Staff();
        model.addAttribute("staff", staff);
        List<String> staffShiftList = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        model.addAttribute("staffShiftList", staffShiftList);
        staff.setStaffShift(staffShiftList);
        return "staff_create";
    }

    @PostMapping("/addStaff")
    public String addStaff(@ModelAttribute("staff") Staff staff, BindingResult result, Model model){
        if(result.hasErrors()){
            return "staff_create";
        }
        List<String> staffShiftList = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        staff.setStaffShift(staffShiftList);
        staffRepository.save(staff);

        return "redirect:/staff";
    }

    // test
    public boolean checkStaff(Staff staff){
        if(staff.getStaffDOB().getYear() < 1970 || staff.getStaffDOB().getYear() > 2005){
            return false;
        }
        else
            return  true;

    }
}