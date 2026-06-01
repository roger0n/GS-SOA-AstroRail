package br.com.fiap.astrorail.service;

import br.com.fiap.astrorail.model.Drone;
import br.com.fiap.astrorail.repository.DroneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {

    private final DroneRepository repository;

    public DroneService(DroneRepository repository) {
        this.repository = repository;
    }

    public Drone salvar(Drone drone) {
        return repository.save(drone);
    }

    public List<Drone> listar() {
        return repository.findAll();
    }

    public Drone buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Drone atualizar(Long id, Drone drone){

        Drone existente = repository.findById(id).orElseThrow();

        existente.setNome(drone.getNome());
        existente.setCapacidadeCarga(drone.getCapacidadeCarga());
        existente.setStatus(drone.getStatus());
        existente.setBateria(drone.getBateria());

        return repository.save(existente);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}