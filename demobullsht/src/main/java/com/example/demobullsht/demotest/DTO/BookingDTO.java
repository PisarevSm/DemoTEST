package com.example.demobullsht.demotest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long id;

    private Long employeeId, workPlaceId;

    private Integer guests;

    private LocalDateTime startBooking, endBooking;

}
