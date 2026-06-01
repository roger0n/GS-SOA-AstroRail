package br.com.fiap.astrorail.service;

import br.com.fiap.astrorail.enums.StatusMissao;
import br.com.fiap.astrorail.model.Drone;
import br.com.fiap.astrorail.model.Missao;
import br.com.fiap.astrorail.model.Regiao;
import br.com.fiap.astrorail.repository.MissaoRepository;
import br.com.fiap.astrorail.service.interfaces.PlanejadorRota;
import org.springframework.stereotype.Service;
import br.com.fiap.astrorail.dto.MissaoDTO;
import br.com.fiap.astrorail.exception.RecursoNaoEncontradoException;
import br.com.fiap.astrorail.repository.DroneRepository;
import br.com.fiap.astrorail.repository.RegiaoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MissaoService {

    private final MissaoRepository repository;
    private final PlanejadorRota planejadorRota;
    private final DroneRepository droneRepository;
    private final RegiaoRepository regiaoRepository;

    public MissaoService(
            MissaoRepository repository,
            PlanejadorRota planejadorRota,
            DroneRepository droneRepository,
            RegiaoRepository regiaoRepository) {

        this.repository = repository;
        this.planejadorRota = planejadorRota;
        this.droneRepository = droneRepository;
        this.regiaoRepository = regiaoRepository;
    }

    public Missao salvar(MissaoDTO dto) {

        Drone drone = droneRepository.findById(dto.getDroneId())
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Drone não encontrado"));

        Regiao regiao = regiaoRepository.findById(dto.getRegiaoId())
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Região não encontrada"));

        Missao missao = new Missao();

        missao.setDrone(drone);
        missao.setRegiao(regiao);
        missao.setDataCriacao(LocalDateTime.now());
        missao.setDataPrevistaEntrega(dto.getDataPrevistaEntrega());
        missao.setStatus(StatusMissao.PLANEJADA);

        System.out.println(planejadorRota.calcularRota());

        return repository.save(missao);
    }

    public List<Missao> listar() {
        return repository.findAll();
    }

    public Missao buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Missao atualizar(Long id, Missao missao){

        Missao existente = repository.findById(id).orElseThrow();

        existente.setStatus(missao.getStatus());
        existente.setDataPrevistaEntrega(
                missao.getDataPrevistaEntrega());

        return repository.save(existente);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}