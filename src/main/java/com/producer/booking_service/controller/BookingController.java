package com.producer.booking_service.controller;

import com.producer.booking_service.Model.BookingModel;
import com.producer.booking_service.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public String book(@RequestBody BookingModel bookingModel){
        this.bookingService.book(bookingModel);
        return "Notification Send Successfully ....";
    }
}
