package com.asociados.wayne.repository;

import com.asociados.wayne.model.Empresa;
import com.asociados.wayne.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    Optional<Empresa> findById(Integer id);

    List<Empresa> findByNombreContainingIgnoreCase(String nombre);

    List<Empresa> findByTipo(Empresa.TipoEmpresa tipo);

    @Query("SELECT e FROM Empresa e WHERE e.tipo = :tipo")
    List<Empresa> findEmpresasTipo(Transaccion.TipoTransaccion tipo);
}