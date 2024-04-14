package com.vladimir.spring.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
/**
 * Модель аудита пользователя
 */
public class Audit {

    private String username;
    private LocalDateTime time;
    private String action;
}
