package com.asociados.wayne.dtos;

import java.util.List;

public record Empresa(
        String nombreEmpresa,
        String descripcionEmpresa,
        String logoEmpresa,
        List<ProductosDtos> productos

) {
}
