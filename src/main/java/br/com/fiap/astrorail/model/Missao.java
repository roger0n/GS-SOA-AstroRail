package br.com.fiap.astrorail.model;

import br.com.fiap.astrorail.enums.StatusMissao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataPrevistaEntrega;

    @Enumerated(EnumType.STRING)
    private StatusMissao status;

    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;

    @ManyToOne
    @JoinColumn(name = "drone_id")
    private Drone drone;
}