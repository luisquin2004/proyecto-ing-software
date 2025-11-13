package com.asociados.wayne.service;

import com.asociados.wayne.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    List<Empresa> findAll();

    Optional<Empresa> findById(Integer id);

}
