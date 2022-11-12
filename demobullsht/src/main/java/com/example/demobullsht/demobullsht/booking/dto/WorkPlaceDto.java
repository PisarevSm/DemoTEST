package com.example.demobullsht.demobullsht.booking.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class WorkPlaceDto {
    private Long id;
    private String Capacity;

}
