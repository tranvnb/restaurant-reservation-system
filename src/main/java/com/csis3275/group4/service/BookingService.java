package com.csis3275.group4.service;

import com.csis3275.group4.entity.Report;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookingService implements IService<Report>{
    @Override
    public void add(Report obj) {

    }

    @Override
    public void delete(UUID Id) {

    }

    @Override
    public void update(UUID Id, Report obj) {

    }

    @Override
    public List<Report> getAll() {
        return null;
    }

    @Override
    public Optional<Report> getById(UUID Id) {
        return Optional.empty();
    }
}
