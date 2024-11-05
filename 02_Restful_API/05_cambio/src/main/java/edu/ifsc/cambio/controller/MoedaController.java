package edu.ifsc.cambio.controller;

import edu.ifsc.cambio.dto.ConversaoResponseDTO;
import edu.ifsc.cambio.dto.CotacaoDTO;
import edu.ifsc.cambio.domain.Moeda;
import edu.ifsc.cambio.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/converter_moeda")
public class MoedaController {

    @Autowired
    private MoedaService moedaService;

    @GetMapping("/{quantia}/{tipoMoeda}/{operacao}")
    public ConversaoResponseDTO converterMoeda(@PathVariable double quantia,
                                               @PathVariable String tipoMoeda,
                                               @PathVariable String operacao) {
        double valorConvertido = moedaService.converterMoeda(quantia, tipoMoeda, operacao);
        return new ConversaoResponseDTO(quantia, tipoMoeda, operacao, valorConvertido);
    }

    @GetMapping("/{quantia}/{operacao}")
    public Map<String, Double> converterParaTodasMoedas(@PathVariable double quantia,
                                                        @PathVariable String operacao) {
        return moedaService.converterParaTodasMoedas(quantia, operacao);
    }

    @GetMapping("/cotacao_moeda")
    public List<CotacaoDTO> listarCotas() {
        List<Moeda> moedas = moedaService.listarCotas();
        return moedas.stream()
                .map(moeda -> new CotacaoDTO(moeda.getTipo(), moeda.getCompra(), moeda.getVenda()))
                .collect(Collectors.toList());
    }
}

