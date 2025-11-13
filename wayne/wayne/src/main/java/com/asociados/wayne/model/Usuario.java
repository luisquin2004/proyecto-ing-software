package com.asociados.wayne.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
@Builder
@Setter
@Getter
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String apellido;
    private String cedula;
    private String correo;
    private String created_At;
    private String fecha_Nacimiento;
    private String nombre;
    private String password;
    private String telefono;

}
