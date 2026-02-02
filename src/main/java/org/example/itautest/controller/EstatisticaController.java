package org.example.itautest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.itautest.dto.EstatisticaDTO;
import org.example.itautest.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @Operation(description = "endpoint para busca de estatistica com busca pelo parametro de tempo passado (segundos)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacao realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "bad request")
    })


    @GetMapping
    public ResponseEntity<EstatisticaDTO> listarEstatisicas(
            @RequestParam(value = "tempoBuscado", required = false, defaultValue = "60") Integer tempoBuscado){

        return ResponseEntity.ok(estatisticaService.calcularEstatisticaTransacao(tempoBuscado));
    }
}
