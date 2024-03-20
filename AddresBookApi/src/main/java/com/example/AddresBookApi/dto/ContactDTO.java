package com.example.AddresBookApi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
    @NotNull(message = "Debe ingresar un nombre")
    private String name;
    @NotNull(message = "Debe ingresar un email")
    private String email;
}
