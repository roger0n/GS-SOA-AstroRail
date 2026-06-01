package br.com.fiap.astrorail.repository;

import br.com.fiap.astrorail.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoRepository
        extends JpaRepository<Missao, Long> {
}