package com.asociados.wayne.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class MovimientoMonetario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private TipoMovimiento tipo;
    private BigDecimal monto;
    private String descripcion;
    private LocalDateTime fecha;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public enum TipoMovimiento {
        INGRESO, EGRESO
    }
}
