package org.example.itautest.controller;

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


    @GetMapping
    public ResponseEntity<EstatisticaDTO> listarEstatisicas(
            @RequestParam(value = "tempoBuscado", required = false, defaultValue = "60") Integer tempoBuscado){

        return ResponseEntity.ok(estatisticaService.calcularEstatisticaTransacao(tempoBuscado));
    }
}
