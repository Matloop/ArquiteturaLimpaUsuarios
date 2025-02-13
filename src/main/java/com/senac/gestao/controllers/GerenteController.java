package com.senac.gestao.controllers;

import com.senac.gestao.models.Gerente;
import com.senac.gestao.services.ServiceEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    private final ServiceEntity<Gerente, Long> gerenteService;

    public GerenteController(ServiceEntity<Gerente, Long> gerenteService) {
        this.gerenteService = gerenteService;
    }

    @PostMapping
    public ResponseEntity<Gerente> criar(@RequestBody Gerente gerente) {
        Gerente novoGerente = gerenteService.salvar(gerente);
        return ResponseEntity.ok(novoGerente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> buscarPorId(@PathVariable Long id) {
        return gerenteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Gerente>> listarTodos() {
        List<Gerente> gerentes = gerenteService.listarTodos();
        return ResponseEntity.ok(gerentes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        gerenteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}