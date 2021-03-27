package com.csis3275.group4.db;

import com.csis3275.group4.entity.Table;
import com.csis3275.group4.repository.TableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    private TableRepository tableRepository;

    public DBSeeder(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Table table1 = new Table(
            "Table1",
                4,
                true
        );
        Table table2 = new Table(
                "Table2",
                4,
                true
        );
        Table table3= new Table(
                "Table3",
                4,
                true
        );
        Table table4 = new Table(
                "Table4",
                4,
                true
        );
        Table table5 = new Table(
                "Table5",
                6,
                true
        );
        Table table6 = new Table(
                "Table6",
                6,
                true
        );
        Table table7 = new Table(
                "Table7",
                8,
                true
        );
        Table table8 = new Table(
                "Table8",
                8,
                true
        );
        Table table9 = new Table(
                "Table9",
                10,
                true
        );
        Table table10 = new Table(
                "Table10",
                10,
                true
        );
        Table table11 = new Table(
                "Table11",
                10,
                true
        );

        // drop all tables
        this.tableRepository.deleteAll();

        // add tables to database
        List<Table> tables = Arrays.asList(table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11);
        this.tableRepository.saveAll(tables);
    }
}
