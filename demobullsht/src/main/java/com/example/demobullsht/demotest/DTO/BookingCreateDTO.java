package com.example.demobullsht.demotest.DTO;

import java.time.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingCreateDTO {
    private Long employeeId, workPlaceId;

    private Integer guests;

    private LocalDateTime startBooking, endBooking;

}
