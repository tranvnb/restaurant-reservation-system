package com.csis3275.group4.repository;

import com.csis3275.group4.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking,String> {
    List<Booking> findByBookingDateAndBookingTime( String bookingDate, int bookingTime);
}
