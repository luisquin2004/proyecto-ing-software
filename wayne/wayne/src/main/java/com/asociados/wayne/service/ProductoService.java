package com.asociados.wayne.service;

import com.asociados.wayne.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(Integer id);

}
