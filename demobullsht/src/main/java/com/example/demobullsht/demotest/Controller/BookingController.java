package com.example.demobullsht.demotest.Controller;

import com.example.demobullsht.demotest.DTO.*;
import com.example.demobullsht.demotest.Entity.*;
import com.example.demobullsht.demotest.Mapper.*;
import com.example.demobullsht.demotest.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    private final EmployeeService employeeService;

    private final WorkPlaceService workPlaceService;

    @GetMapping("/")
    public List<BookingDTO> getBooking() {
        List<BookingEntity> entityList = bookingService.getAllBooking();
        return entityList
            .stream()
            .map(BookingMapper::mapBookingEntityToDto)
            .toList();
    }

    @GetMapping("/{id}")
    public BookingDTO getFindById(@PathVariable Long id) {
        return BookingMapper
            .mapBookingEntityToDto(bookingService.getBookingById(id));
    }

    @PostMapping
    public void addNewBooking(@RequestBody BookingCreateDTO bookingCreateDTO) {
        WorkPlaceEntity workPlaceEntity = workPlaceService.getWorkPlaceById(bookingCreateDTO.getWorkPlaceId());
        EmployeeEntity employeeEntity = employeeService.getEmployee(bookingCreateDTO.getEmployeeId());

        BookingEntity bookingEntity = BookingMapper.mapCreateDtoToBookingEntity(
            bookingCreateDTO, employeeEntity, workPlaceEntity);
        bookingService.addNewBooking(bookingEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

}
