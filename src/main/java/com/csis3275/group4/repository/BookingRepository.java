package com.csis3275.group4.repository;

import com.csis3275.group4.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking,String> {

    List<Booking> findByBookingDateAndBookingTime(String bookingDate, int bookingTime);
}
