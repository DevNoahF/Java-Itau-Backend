package org.example.itautest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.itautest.dto.TransacaoDTO;
import org.example.itautest.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService service;

    @Operation(description = "endpoint para adicionar uma transacao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "transacao criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "error bad request")
    })

    @PostMapping
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoDTO request){
        service.adicionarTransacao(request);
        return ResponseEntity.ok().build();
    }


    @Operation(description = "endpoint para deletar todas as transacoes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "transacao deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "error bad request")
    })
    @DeleteMapping
    public ResponseEntity<Void> deletarTransacao(){
        service.deletarTransacao();
        return ResponseEntity.ok().build();
    }
}
