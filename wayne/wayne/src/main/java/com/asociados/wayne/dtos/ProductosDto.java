package com.asociados.wayne.dtos;

public record ProductosDto(
        String nombre,
        String descripcion,
        Double precio,
        String nombreEmpresa,
        String categoriaProductos,
        String logo
) {
}
