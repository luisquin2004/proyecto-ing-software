package com.asociados.wayne.dtos;

import com.asociados.wayne.model.Producto;

import java.util.List;

public record EmpresaDto(
        String nombreEmpresa,
        String descripcionEmpresa,
        String logoEmpresa,
        List<Producto> productos

) {
}
