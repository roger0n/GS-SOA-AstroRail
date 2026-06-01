package br.com.fiap.astrorail.service;

import br.com.fiap.astrorail.model.Regiao;
import br.com.fiap.astrorail.repository.RegiaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiaoService {

    private final RegiaoRepository repository;

    public RegiaoService(RegiaoRepository repository) {
        this.repository = repository;
    }

    public List<Regiao> listar() {
        return repository.findAll();
    }

    public Regiao salvar(Regiao regiao) {
        return repository.save(regiao);
    }

    public Regiao buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Regiao atualizar(Long id, Regiao regiao){

        Regiao existente = repository.findById(id).orElseThrow();

        existente.setNome(regiao.getNome());
        existente.setTipoRegiao(regiao.getTipoRegiao());
        existente.setNivelRisco(regiao.getNivelRisco());
        existente.setLatitude(regiao.getLatitude());
        existente.setLongitude(regiao.getLongitude());

        return repository.save(existente);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}