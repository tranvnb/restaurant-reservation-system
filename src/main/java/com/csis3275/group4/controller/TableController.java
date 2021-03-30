package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Table;
import com.csis3275.group4.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TableController {

    private TableRepository tableRepository;

    public TableController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @GetMapping("/table")
    public String showTable(Model model){
        model.addAttribute("tables", tableRepository.findAll());
        return "table_display";
    }

    @GetMapping("/createTable")
    public String createTableForm(Model model){
        Table table = new Table();
        model.addAttribute("table", table);
        return "table_create";
    }
    @PostMapping("/addtable")
        public String addTable(@ModelAttribute("table") Table table, BindingResult result, Model model){
        if(result.hasErrors()){
            return "table_create";
        }

        tableRepository.save(table);

        return "redirect:/table";

    }

    @GetMapping("/editTable/{id}")
    public String editTable(@PathVariable("id") String id, Model model){
        Table table = tableRepository.findById(id).get();
        model.addAttribute("table", table);
        return "table_update";
    }

    @PostMapping("/updateTable/{id}")
    public String updateTable(@PathVariable("id") String id, @ModelAttribute("table") Table table, BindingResult result, Model model){
        if(result.hasErrors()){
            table.setId(id);
            return "table_update";
        }
        tableRepository.save(table);
        return "redirect:/table";

    }

    @GetMapping("/deleteTable/{id}")
    public String deteleTable(@PathVariable("id") String id, Model model){
        Table table = tableRepository.findById(id).get();
        tableRepository.delete(table);
        return "redirect:/table";
    }

}
