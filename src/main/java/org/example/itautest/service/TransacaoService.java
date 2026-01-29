package org.example.itautest.service;

import lombok.extern.slf4j.Slf4j;
import org.example.itautest.dto.TransacaoDTO;
import org.example.itautest.infra.exceptions.UnprocessableEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TransacaoService {

    private final List<TransacaoDTO> listTransacao = new ArrayList<>();

    public void adicionarTransacao(TransacaoDTO transacaoDTO){
        log.info("metodo adicionar esta rodando");
        if (transacaoDTO.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e hora nao podem ser no futuro");
             throw new UnprocessableEntity("Data e hora nao podem ser no futuro");
        }
        if (transacaoDTO.valor() < 0){
            log.error("valor nao pode ser menor que 0");
            throw new UnprocessableEntity("valor nao pode ser menor que 0");
        }
        listTransacao.add(transacaoDTO);
    }

    public void deletarTransacao(){
        log.info("transacoes deletadas");
        listTransacao.clear();
    }

    public List<TransacaoDTO> gerarEstatistica(Integer tempoBusca){
        OffsetDateTime dataHoraBuscada = OffsetDateTime.now().minusSeconds(tempoBusca);

        return listTransacao.stream()
                .filter(transacao -> transacao.dataHora().isAfter(dataHoraBuscada))
                .toList();
    }

}
