package com.asociados.wayne.repository;

import com.asociados.wayne.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNombre(String nombre);

    List<Categoria> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT c FROM Categoria c WHERE c.descripcion LIKE %:descripcion%")
    List<Categoria> buscarPorDescripcion(String descripcion);
}