package com.asociados.wayne.dtos;

public record ProductosDtos(
        String nombre,
        String descripcion,
        Double precio,
        String nombreEmpresa,
        String categoriaProductos,
        String logo
) {
}
