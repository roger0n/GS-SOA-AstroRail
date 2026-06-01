package br.com.fiap.astrorail.controller;

import br.com.fiap.astrorail.model.Missao;
import br.com.fiap.astrorail.service.MissaoService;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.astrorail.dto.MissaoDTO;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService service;

    public MissaoController(MissaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Missao> listar() {
        return service.listar();
    }

    @PostMapping
    public Missao salvar(@RequestBody MissaoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public Missao buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Missao atualizar(
            @PathVariable Long id,
            @RequestBody Missao missao){

        return service.atualizar(id, missao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}