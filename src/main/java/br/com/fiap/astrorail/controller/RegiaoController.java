package br.com.fiap.astrorail.controller;

import br.com.fiap.astrorail.model.Regiao;
import br.com.fiap.astrorail.service.RegiaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regioes")
public class RegiaoController {

    private final RegiaoService service;

    public RegiaoController(RegiaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Regiao> listar() {
        return service.listar();
    }

    @PostMapping
    public Regiao salvar(@RequestBody Regiao regiao) {
        return service.salvar(regiao);
    }

    @GetMapping("/{id}")
    public Regiao buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Regiao atualizar(
            @PathVariable Long id,
            @RequestBody Regiao regiao){

        return service.atualizar(id, regiao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}