package org.example.itautest.dto;

import java.time.OffsetDateTime;

public record TransacaoDTO(double valor,
                           OffsetDateTime dataHora) {
}
