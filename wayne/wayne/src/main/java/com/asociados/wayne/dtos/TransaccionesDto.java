package com.asociados.wayne.dtos;

import java.time.LocalDateTime;

public record TransaccionesDto(LocalDateTime fechaDeEmision, String referencia, Double montoTransferido, String rif){}
