package com.senac.gestao.aplication.services.impls;

import com.senac.gestao.domain.models.enums.Contato;
import com.senac.gestao.domain.repositories.ContatoRepository;
import com.senac.gestao.aplication.services.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoServiceImpl implements ServiceEntity<Contato, Long> {

    private final ContatoRepository contatoRepository;

    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato salvar(Contato entity) {
        return contatoRepository.save(entity);
    }

    @Override
    public Optional<Contato> buscarPorId(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        contatoRepository.deleteById(id);
    }
}