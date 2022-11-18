package com.example.demobullsht.demotest.Service;

import com.example.demobullsht.demotest.Entity.*;
import com.example.demobullsht.demotest.Entity.Repository.*;
import com.example.demobullsht.demotest.Exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    /*private final EmployeeEntity employeeEntity;
    private final WorkPlaceEntity workPlaceEntity;*/

    public List<BookingEntity> getAllBooking(){
        return bookingRepository.findAll();
    }

    public BookingEntity getBookingById(Long id){
        return bookingRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException("Бронирование не найдено"));
    }

    public void addNewBooking(BookingEntity bookingEntity){
        /*employeeEntity.addBooking(bookingEntity);
        workPlaceEntity.addBooking(bookingEntity);*/
        bookingRepository.save(bookingEntity);
    }

    public void updateBooking(BookingEntity bookingEntity){
        bookingRepository.save(bookingEntity);
    }

    public void deleteBooking(Long bookingId){
        BookingEntity bookingEntity = bookingRepository
            .findById(bookingId)
            .orElseThrow(() -> new NotFoundException("Бронь не найдена"));
        /*employeeEntity.removeBooking(bookingEntity);
        workPlaceEntity.removeBooking(bookingEntity);*/
        bookingRepository.deleteById(bookingId);
    }
}
