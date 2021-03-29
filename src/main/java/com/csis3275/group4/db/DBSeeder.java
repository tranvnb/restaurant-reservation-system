package com.csis3275.group4.db;

import com.csis3275.group4.entity.Service;
import com.csis3275.group4.entity.Table;
import com.csis3275.group4.repository.ServiceRepository;
import com.csis3275.group4.repository.StaffRepository;
import com.csis3275.group4.repository.TableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    private TableRepository tableRepository;
    private ServiceRepository serviceRepository;

    public DBSeeder(TableRepository tableRepository,ServiceRepository serviceRepository) {
        this.tableRepository = tableRepository;
        this.serviceRepository = serviceRepository;
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

        Service service1 = new Service("Service1",56);
        Service service2 = new Service("Service2",32);
        Service service3 = new Service("Service3",26);
        Service service4 = new Service("Service4",88);
        Service service5 = new Service("Service5",42);

        // drop all tables
        this.tableRepository.deleteAll();
        this.serviceRepository.deleteAll();

        // add tables to database
        List<Table> tables = Arrays.asList(table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11);
        List<Service> services = Arrays.asList(service1,service2,service3,service4,service5);
        this.tableRepository.saveAll(tables);
        this.serviceRepository.saveAll(services);
    }
}
