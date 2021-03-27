package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Table;
import com.csis3275.group4.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    private TableRepository tableRepository;

    public TableController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @GetMapping("table")
    public String ShowTable(Model model){
        Table table = new Table();
        model.addAttribute("table", tableRepository.findAll());
        return "table_display";
    }
}
