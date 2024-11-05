package edu.ifsc.cambio.service;

import edu.ifsc.cambio.domain.Moeda;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MoedaService {
    private final Map<String, Moeda> moedas;

    public MoedaService() {
        moedas = new HashMap<>();
        moedas.put("DC", new Moeda("DC", 5.6061, 5.6066));
        moedas.put("DP", new Moeda("DP", 5.69, 5.79));
        moedas.put("DX", new Moeda("DX", 5.6058, 5.6064));
        moedas.put("DT", new Moeda("DT", 5.5430, 5.7530));
        moedas.put("EU", new Moeda("EU", 6.5630, 6.8070));
        moedas.put("OU", new Moeda("OU", 346.70, 346.70)); // Taxa fixa para compra e venda de ouro
    }

    public double converterMoeda(double quantia, String tipoMoeda, String operacao) {
        Moeda moeda = moedas.get(tipoMoeda.toUpperCase());
        if (moeda == null) throw new IllegalArgumentException("Tipo de moeda inválido.");

        double taxa = operacao.equalsIgnoreCase("compra") ? moeda.getCompra() : moeda.getVenda();
        return tipoMoeda.equalsIgnoreCase("OU") ? quantia / taxa : quantia / taxa;
    }

    public Map<String, Double> converterParaTodasMoedas(double quantia, String operacao) {
        return moedas.values().stream()
                .collect(Collectors.toMap(
                        Moeda::getTipo,
                        moeda -> quantia / (operacao.equalsIgnoreCase("compra") ? moeda.getCompra() : moeda.getVenda())
                ));
    }

    public List<Moeda> listarCotas() {
        return moedas.values().stream().collect(Collectors.toList());
    }
}

