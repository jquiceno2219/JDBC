package org.example.domain.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Producto {
    private long id;
    private String nombre;
    private double precio;
    private Date fechaRegistro;
}