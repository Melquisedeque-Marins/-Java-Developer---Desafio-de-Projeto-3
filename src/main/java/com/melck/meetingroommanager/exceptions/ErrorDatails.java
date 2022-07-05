package com.melck.meetingroommanager.exceptions;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDatails {
    
    private Instant timestamp;
    private Integer status;
    private String details;
}
