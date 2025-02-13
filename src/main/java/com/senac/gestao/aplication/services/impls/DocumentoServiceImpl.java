package com.senac.gestao.aplication.services.impls;

import com.senac.gestao.domain.models.enums.Documento;
import com.senac.gestao.domain.repositories.DocumentoRepository;
import com.senac.gestao.aplication.services.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoServiceImpl implements ServiceEntity<Documento, Long> {

    private final DocumentoRepository documentoRepository;

    public DocumentoServiceImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public Documento salvar(Documento entity) {
        return documentoRepository.save(entity);
    }

    @Override
    public Optional<Documento> buscarPorId(Long id) {
        return documentoRepository.findById(id);
    }

    @Override
    public List<Documento> listarTodos() {
        return documentoRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        documentoRepository.deleteById(id);
    }
}