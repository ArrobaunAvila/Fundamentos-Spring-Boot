package com.Fundamentos.dto;

import java.time.LocalDate;
import lombok.*;

@Builder
@Data
@ToString
public class UserDto {

    private Long id;
    private LocalDate birthday;
    private String name;
    private String email;


}
