package br.com.fiap.astrorail.controller;

import br.com.fiap.astrorail.model.Drone;
import br.com.fiap.astrorail.service.DroneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drones")
public class DroneController {

    private final DroneService service;

    public DroneController(DroneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Drone> listar() {
        return service.listar();
    }

    @PostMapping
    public Drone salvar(@RequestBody Drone drone) {
        return service.salvar(drone);
    }

    @GetMapping("/{id}")
    public Drone buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Drone atualizar(
            @PathVariable Long id,
            @RequestBody Drone drone){

        return service.atualizar(id, drone);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}