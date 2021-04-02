package com.csis3275.group4.service;

import com.csis3275.group4.entity.Booking;
import com.csis3275.group4.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService implements IService<Booking> {

    @Autowired
    BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void add(Booking obj) {
        this.bookingRepository.insert(obj);
    }

    @Override
    public void delete(UUID Id) {

    }

    @Override
    public void update(UUID Id, Booking obj) {

    }

    @Override
    public List<Booking> getAll() {
        return this.bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getById(UUID Id) {
        return Optional.empty();
    }

}
