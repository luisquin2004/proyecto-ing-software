package com.asociados.wayne.repository;

import com.asociados.wayne.model.MovimientoMonetario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientoMonetarioRepository extends JpaRepository<MovimientoMonetario, Integer> {

    List<MovimientoMonetario> findByTipo(MovimientoMonetario.TipoMovimiento tipo);

    List<MovimientoMonetario> findByEmpresaId(Integer empresaId);

    List<MovimientoMonetario> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("SELECT SUM(m.monto) FROM MovimientoMonetario m WHERE m.tipo = :tipo AND m.fecha BETWEEN :fechaInicio AND :fechaFin")
    BigDecimal sumMovimientosEnPeriodo(@Param("tipo") MovimientoMonetario.TipoMovimiento tipo,
                                       @Param("fechaInicio") LocalDateTime fechaInicio,
                                       @Param("fechaFin") LocalDateTime fechaFin);

    default BigDecimal sumIngresosEnPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return sumMovimientosEnPeriodo(MovimientoMonetario.TipoMovimiento.INGRESO, fechaInicio, fechaFin);
    }

    default BigDecimal sumEgresosEnPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return sumMovimientosEnPeriodo(MovimientoMonetario.TipoMovimiento.EGRESO, fechaInicio, fechaFin);
    }

    @Query("SELECT m FROM MovimientoMonetario m WHERE m.transaccionId = :transaccionId")
    List<MovimientoMonetario> findByTransaccionId(@Param("transaccionId") Integer transaccionId);
}