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
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private TipoTransaccion tipo;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    private BigDecimal total;
    private String referencia;
    private BigDecimal montoReferencia;
    private BigDecimal montoTransferido;
    private String cedulaOrRif;
    private LocalDateTime createdAt;

    public enum TipoTransaccion {
        VENTA, COMPRA
    }
}
