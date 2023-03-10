package com.validation.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponseDto {
    private LocalDateTime date;
    private  String body;
    private  String errorMessage;
}
