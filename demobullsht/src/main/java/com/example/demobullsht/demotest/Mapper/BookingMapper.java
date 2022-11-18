package com.example.demobullsht.demotest.Mapper;

import com.example.demobullsht.demotest.DTO.*;
import com.example.demobullsht.demotest.Entity.*;


public class BookingMapper {

    public static BookingDTO mapBookingEntityToDto(BookingEntity bookingEntity) {
        return new BookingDTO(
            bookingEntity.getId(),
            bookingEntity.getEmployee().getId(),
            bookingEntity.getWorkPlace().getId(),
            bookingEntity.getGuests(),
            bookingEntity.getStartBooking(),
            bookingEntity.getEndBooking()
        );
    }

    public static BookingEntity mapCreateDtoToBookingEntity(
        BookingCreateDTO bookingCreateDTO,
        EmployeeEntity employeeEntity,
        WorkPlaceEntity workPlaceEntity
    ) {
        return new BookingEntity(
            bookingCreateDTO.getGuests(),
            bookingCreateDTO.getStartBooking(),
            bookingCreateDTO.getEndBooking(),
            workPlaceEntity,
            employeeEntity
        );
    }

}
