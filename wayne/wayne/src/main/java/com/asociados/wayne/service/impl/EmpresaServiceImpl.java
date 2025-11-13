package com.asociados.wayne.service.impl;

import com.asociados.wayne.model.Empresa;
import com.asociados.wayne.repository.EmpresaRepository;
import com.asociados.wayne.service.EmpresaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> findById(Integer id) {
        return empresaRepository.findById(id);
    }
}
