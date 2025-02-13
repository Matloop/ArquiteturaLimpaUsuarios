package com.senac.gestao.controllers;

import com.senac.gestao.domain.models.enums.Contato;
import com.senac.gestao.aplication.services.ServiceEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ServiceEntity<Contato, Long> contatoService;

    public ContatoController(ServiceEntity<Contato, Long> contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<Contato> criar(@RequestBody Contato contato) {
        Contato novoContato = contatoService.salvar(contato);
        return ResponseEntity.ok(novoContato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarPorId(@PathVariable Long id) {
        return contatoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarTodos() {
        List<Contato> contatos = contatoService.listarTodos();
        return ResponseEntity.ok(contatos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        contatoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}