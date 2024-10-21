package com.producer.booking_service.Service;

import com.producer.booking_service.Model.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    // key --> topic , value --> req object/data
    @Autowired
    private KafkaTemplate<String,BookingModel> kafkaTemplate;

    public void book(BookingModel bookingModel) {
        //logic to book the ticket
        if(bookingModel.getStatus().equalsIgnoreCase("completed")){
            //sending notification to broker for tpic booking-topic
            this.kafkaTemplate.send("booking-topic",bookingModel);
        }
    }
}
