package org.example.itautest.controller;

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

    @PostMapping
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoDTO request){
        service.adicionarTransacao(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTransacao(){
        service.deletarTransacao();
        return ResponseEntity.ok().build();
    }
}
