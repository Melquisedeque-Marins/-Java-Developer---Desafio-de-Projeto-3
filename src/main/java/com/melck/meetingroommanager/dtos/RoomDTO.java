package com.melck.meetingroommanager.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
  
    private Long id;
    private String name;  
    private String date;
    private String startHour;
    private String endHour;

}
