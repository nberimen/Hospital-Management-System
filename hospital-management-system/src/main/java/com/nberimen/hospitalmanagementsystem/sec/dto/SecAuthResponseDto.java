package com.nberimen.hospitalmanagementsystem.sec.dto;

import lombok.Data;

@Data
public class SecAuthResponseDto {

    private Long id;
    private Long identityNo;
    private String token;
    private String role;
}
