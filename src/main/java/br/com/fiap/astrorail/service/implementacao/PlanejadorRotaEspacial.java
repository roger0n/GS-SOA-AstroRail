package br.com.fiap.astrorail.service.implementacao;

import br.com.fiap.astrorail.service.interfaces.PlanejadorRota;
import org.springframework.stereotype.Service;

@Service
public class PlanejadorRotaEspacial implements PlanejadorRota {

    @Override
    public String calcularRota() {
        return "Rota otimizada inspirada em logística espacial";
    }
}