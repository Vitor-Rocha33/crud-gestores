package com.vitor.gestorescrud.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ManagerNewDTO {

    private String registration;
    private String name;
    private String dateOfBirth;
    private String sector;
}
