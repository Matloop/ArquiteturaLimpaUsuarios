package com.senac.gestao.controllers;

import com.senac.gestao.domain.models.enums.Documento;
import com.senac.gestao.aplication.services.ServiceEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    private final ServiceEntity<Documento, Long> documentoService;

    public DocumentoController(ServiceEntity<Documento, Long> documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping
    public ResponseEntity<Documento> criar(@RequestBody Documento documento) {
        Documento novoDocumento = documentoService.salvar(documento);
        return ResponseEntity.ok(novoDocumento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> buscarPorId(@PathVariable Long id) {
        return documentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Documento>> listarTodos() {
        List<Documento> documentos = documentoService.listarTodos();
        return ResponseEntity.ok(documentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        documentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}