package com.asociados.wayne.repository;

import com.asociados.wayne.model.MovimientoMonetario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoMonetarioRepository extends JpaRepository<MovimientoMonetario, Integer> {}