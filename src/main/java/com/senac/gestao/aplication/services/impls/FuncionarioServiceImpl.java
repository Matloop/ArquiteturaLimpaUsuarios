package com.senac.gestao.aplication.services.impls;

import com.senac.gestao.domain.models.enums.Funcionario;
import com.senac.gestao.domain.repositories.FuncionarioRepository;
import com.senac.gestao.aplication.services.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements ServiceEntity<Funcionario, Long> {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario salvar(Funcionario entity) {
        return funcionarioRepository.save(entity);
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        funcionarioRepository.deleteById(id);
    }
}