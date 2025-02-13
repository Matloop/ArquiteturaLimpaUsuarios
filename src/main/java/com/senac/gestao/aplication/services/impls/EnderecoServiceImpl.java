package com.senac.gestao.aplication.services.impls;

import com.senac.gestao.domain.models.enums.Endereco;
import com.senac.gestao.domain.repositories.EnderecoRepository;
import com.senac.gestao.aplication.services.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements ServiceEntity<Endereco, Long> {

    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco salvar(Endereco entity) {
        return enderecoRepository.save(entity);
    }

    @Override
    public Optional<Endereco> buscarPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    @Override
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        enderecoRepository.deleteById(id);
    }
}