package br.com.fiap.astrorail.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Drone extends Veiculo {

    private Double bateria;

    @Override
    public Double calcularAutonomia() {
        return bateria * 10;
    }
}