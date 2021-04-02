package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Booking;
import com.csis3275.group4.entity.Table;
import com.csis3275.group4.repository.BookingRepository;
import com.csis3275.group4.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TableController {

    private TableRepository tableRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public TableController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @GetMapping("/table")
    public String showTable(Model model){
        List<Table> allTables = tableRepository.findAll();
        for(Table o : allTables){o.setAvailable(true);tableRepository.save(o);}
        model.addAttribute("tables", tableRepository.findAll());
        model.addAttribute("bookings",bookingRepository.findByBookingDateAndBookingTime("2021-04-06",22));
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

    @GetMapping("/availableTable/{date}{time}")
    public String showAvailableTable(Model model, @RequestParam(value ="date") String date, @RequestParam(value = "time") String time) {
        if(date == "" || time == ""){
            return "index";
        }
        int t = Integer.valueOf(time);

        List<Table> allTables = tableRepository.findAll();
        for(Table o : allTables){o.setAvailable(true);tableRepository.save(o);}
        List<Booking> bookedTables = bookingRepository.findByBookingDateAndBookingTime(date,t);

        if(bookedTables == null){
            model.addAttribute("tables", tableRepository.findByisAvailableIsTrue(true));
            return "table_booking";
        }
        for(Booking o : bookedTables){
            String bookedTableId = o.getTables().get(0).getId();
            Table table = tableRepository.findById(bookedTableId).get();
            table.setAvailable(false);
            tableRepository.save(table);
        }
        model.addAttribute("tables", tableRepository.findByisAvailableIsTrue(true));
        return "table_booking";
    }

}
