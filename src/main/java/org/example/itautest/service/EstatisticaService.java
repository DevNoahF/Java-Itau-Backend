package org.example.itautest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.itautest.dto.EstatisticaDTO;
import org.example.itautest.dto.TransacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticaService {
    private final TransacaoService transacaoService;

    public EstatisticaDTO calcularEstatisticaTransacao(Integer tempoBuscado){
        log.info("iniciando o retorno da busca de estatisticas de transacoes");
        List<TransacaoDTO> listTransacao = transacaoService.gerarEstatistica(tempoBuscado);

        DoubleSummaryStatistics doubleSummaryStatistics = listTransacao.stream()
                .mapToDouble(TransacaoDTO::valor)
                .summaryStatistics();

        log.info("estatisticas retornada por sucesso");
        if (!(doubleSummaryStatistics.getCount() == 0)) {
            return new EstatisticaDTO(doubleSummaryStatistics.getCount(),
                    doubleSummaryStatistics.getSum(),
                    doubleSummaryStatistics.getAverage(),
                    doubleSummaryStatistics.getMin(),
                    doubleSummaryStatistics.getMax());
        }else{
            log.debug("provavemente algum erro envolvendo os numero igualados a zero");
            return new EstatisticaDTO(0L,0,0,0,0);
        }

    }



}
