package com.example.AddresBookApi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
    @NotBlank(message = "Debe ingresar un nombre")
    private String name;
    @Email(message = "El formato del email es inválido")
    @NotBlank(message = "Debe ingresar un email")
    private String email;
}
