package com.csis3275.group4.controller;

import com.csis3275.group4.repository.ServiceRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {
    private ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("service")
    public String showService(Model model){
        model.addAttribute("services", serviceRepository.findAll());
        return "service_display";
    }
}
