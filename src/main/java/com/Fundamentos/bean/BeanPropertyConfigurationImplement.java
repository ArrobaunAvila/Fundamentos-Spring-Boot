package com.Fundamentos.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class BeanPropertyConfigurationImplement implements BeanPropertyConfiguration{


    private String name;
    private String apellido;

    @Override
    public String propertyUsuario() {
        return this.name + '-'  + this.apellido;
    }
}
