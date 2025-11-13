package com.asociados.wayne.service.impl;

import com.asociados.wayne.model.Empresa;
import com.asociados.wayne.model.Transaccion;
import com.asociados.wayne.repository.TransaccionRepository;
import com.asociados.wayne.repository.EmpresaRepository;
import com.asociados.wayne.service.TransaccionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final EmpresaRepository empresaRepository;

    public TransaccionServiceImpl(TransaccionRepository transaccionRepository, EmpresaRepository empresaRepository) {
        this.transaccionRepository = transaccionRepository;
        this.empresaRepository = empresaRepository;
    }

    @Override
    public List<Transaccion> findAll() {
        return transaccionRepository.findAll();
    }

}
