package com.vitor.gestorescrud.dto;

import com.vitor.gestorescrud.domain.Manager;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class ManagerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 3 e 120")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatorio")
    private String dateOfBirth;

    @NotEmpty(message = "Preenchimento obrigatorio")
    private String sector;

    public ManagerDTO() {

    }

    public ManagerDTO(Manager obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.dateOfBirth = obj.getDateOfBirth();
        this.sector = obj.getSector();
    }
}
