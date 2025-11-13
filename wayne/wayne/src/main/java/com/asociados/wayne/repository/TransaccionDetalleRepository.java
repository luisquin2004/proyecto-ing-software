package com.asociados.wayne.repository;

import com.asociados.wayne.model.TransaccionDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionDetalleRepository extends JpaRepository<TransaccionDetalle, Integer> {}