package com.asociados.wayne.repository;

import com.asociados.wayne.model.Transaccion;
import com.asociados.wayne.model.TransaccionDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransaccionDetalleRepository extends JpaRepository<TransaccionDetalle, Integer> {

    List<TransaccionDetalle> findByTransaccionId(Integer transaccionId);

    List<TransaccionDetalle> findByProductoId(Integer productoId);

    @Query("SELECT td FROM TransaccionDetalle td WHERE td.transaccionId IN (SELECT t.id FROM Transaccion t WHERE t.empresaId = :empresaId)")
    List<TransaccionDetalle> findByEmpresaId(@Param("empresaId") Integer empresaId);

    @Query("SELECT td.productoId, SUM(td.cantidad) as totalVendido " +
            "FROM TransaccionDetalle td " +
            "WHERE td.transaccionId IN (SELECT t.id FROM Transaccion t WHERE t.tipo = :tipoTransaccion) " +
            "GROUP BY td.productoId " +
            "ORDER BY totalVendido DESC")
    List<Object[]> findProductosMasTransaccionados(@Param("tipoTransaccion") Transaccion.TipoTransaccion tipoTransaccion);

}