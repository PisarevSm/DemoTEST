package com.example.demobullsht.demotest.controller;

import java.time.*;
import java.util.*;

import com.example.demobullsht.demotest.dto.*;
import com.example.demobullsht.demotest.entity.*;
import com.example.demobullsht.demotest.mapper.*;
import com.example.demobullsht.demotest.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workplace")
public class OfficeController {

    private final OfficeService officeService;

    private final OfficeMapper officeMapper;

    @PostMapping("/")
    public ResponseEntity<String> createOffice(
        CityEntity city, String address, String workNumber, LocalTime startOfDay,
        LocalTime endOfDay, Integer bookingRange
    ) {
        officeService.addOffice(city, address, workNumber, startOfDay, endOfDay, bookingRange);

        return ResponseEntity.ok("Офис успешно создан.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<OfficeDto>> getOffice() {
        List<OfficeDto> office;

        office = officeService.getAll()
            .stream()
            .map(officeMapper::officeToDto)
            .toList();

        return ResponseEntity.ok(office);
    }

    @GetMapping("/id{id}")
    public ResponseEntity<OfficeDto> getOfficeById(@PathVariable Long id) {
        return ResponseEntity.ok(officeMapper.officeToDto(officeService.getById(id))
        );
    }
    @GetMapping("/id{address}")
    public ResponseEntity<OfficeDto> getOfficeByAddress(@PathVariable String address) {
        return ResponseEntity.ok(officeMapper.officeToDto(officeService.getByAddress(address))
        );
    }
    @GetMapping("/id{workNumber}")
    public ResponseEntity<OfficeDto> getOfficeByWorkNumber(@PathVariable String workNumber) {
        return ResponseEntity.ok(officeMapper.officeToDto(officeService.getByWorkNumber(workNumber))
        );
    }

    @PutMapping("/")
    public void updateOffice(
        @PathVariable("officeId") Long id,
        @RequestBody OfficeDto officeDto
    ) {

        OfficeEntity officeEntity = officeService.getById(id);

        if (officeDto.getAddress() != null &&
            officeDto.getAddress().length() > 0 &&
            !Objects.equals(officeEntity.getAddress(), officeDto.getAddress())) {
            officeEntity.setAddress(officeDto.getAddress());
        }
        if (officeDto.getWorkNumber() != null &&
            officeDto.getWorkNumber().length() > 0 &&
            !Objects.equals(officeEntity.getWorkNumber(), officeDto.getWorkNumber())) {
            officeEntity.setWorkNumber(officeDto.getWorkNumber());
        }
        if (officeDto.getStartOfDay() != null &&
            !Objects.equals(officeEntity.getStartOfDay(), officeDto.getStartOfDay())) {
            officeEntity.setStartOfDay(officeDto.getStartOfDay());
        }
        if (officeDto.getEndOfDay() != null &&
            !Objects.equals(officeEntity.getEndOfDay(), officeDto.getEndOfDay())) {
            officeEntity.setEndOfDay(officeDto.getEndOfDay());
        }
        if (officeDto.getBookingRange() != null &&
            officeDto.getBookingRange().longValue() > 0 &&
            !Objects.equals(officeEntity.getBookingRange(), officeDto.getBookingRange())) {
            officeEntity.setBookingRange(officeDto.getBookingRange());
        }
        officeService.updateOffice(officeEntity);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOffice(@PathVariable Long id) {
        officeService.deleteOffice(id);

        return ResponseEntity.ok("Офис удален.");
    }

}
