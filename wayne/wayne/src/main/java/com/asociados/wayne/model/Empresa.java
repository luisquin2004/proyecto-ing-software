package com.asociados.wayne.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String rfc;
    private String descripcion;
    private String logo;
    private TipoEmpresa tipo;
    private LocalDateTime createdAt;

    public enum TipoEmpresa {
        EXPORTADORA, IMPORTADORA, AMBAS
    }
}
