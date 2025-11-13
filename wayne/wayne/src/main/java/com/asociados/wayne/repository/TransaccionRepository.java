package com.asociados.wayne.repository;

import com.asociados.wayne.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {

    List<Transaccion> findByTipo(Transaccion.TipoTransaccion tipo);

    List<Transaccion> findByEmpresaId(Integer empresaId);

    List<Transaccion> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("SELECT t FROM Transaccion t WHERE t.empresaId = :empresaId AND t.tipo = :tipo")
    List<Transaccion> findByEmpresaIdAndTipo(Integer empresaId, Transaccion.TipoTransaccion tipo);
}