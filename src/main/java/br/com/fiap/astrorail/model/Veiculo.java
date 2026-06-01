package br.com.fiap.astrorail.model;

import br.com.fiap.astrorail.enums.StatusVeiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double capacidadeCarga;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    public abstract Double calcularAutonomia();
}