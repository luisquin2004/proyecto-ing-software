package com.asociados.wayne.service;

import com.asociados.wayne.dtos.EmpresaDto;
import java.util.List;

public interface EmpresaService {

    List<EmpresaDto> findAll();

    EmpresaDto findById(Integer id);

}
