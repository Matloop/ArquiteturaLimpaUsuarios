package com.senac.gestao.aplication.services.impls;

import com.senac.gestao.domain.models.enums.Cliente;
import com.senac.gestao.domain.repositories.ClienteRepository;
import com.senac.gestao.aplication.services.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ServiceEntity<Cliente, Long> {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente salvar(Cliente entity) {
        return clienteRepository.save(entity);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}