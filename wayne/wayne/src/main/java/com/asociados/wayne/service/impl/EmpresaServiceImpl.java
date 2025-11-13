package com.asociados.wayne.service.impl;

import com.asociados.wayne.dtos.EmpresaDto;
import com.asociados.wayne.repository.EmpresaRepository;
import com.asociados.wayne.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDto> findAll() {
        return empresaRepository.findAll().stream().map(
                e -> new EmpresaDto(e.getNombre(), e.getDescripcion(), e.getLogo(), e.getProductos())).toList();
    }

    @Override
    public EmpresaDto findById(Integer id) {
        return empresaRepository.findById(id).map(e ->
                new EmpresaDto(e.getNombre(), e.getDescripcion(), e.getLogo(), e.getProductos()))
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
    }
}
