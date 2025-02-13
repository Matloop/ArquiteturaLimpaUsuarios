package com.senac.gestao.aplication.services.impls;

import com.senac.gestao.domain.models.enums.Gerente;
import com.senac.gestao.domain.repositories.GerenteRepository;
import com.senac.gestao.aplication.services.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteServiceImpl implements ServiceEntity<Gerente, Long> {

    private final GerenteRepository gerenteRepository;

    public GerenteServiceImpl(GerenteRepository gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }

    @Override
    public Gerente salvar(Gerente entity) {
        return gerenteRepository.save(entity);
    }

    @Override
    public Optional<Gerente> buscarPorId(Long id) {
        return gerenteRepository.findById(id);
    }

    @Override
    public List<Gerente> listarTodos() {
        return gerenteRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        gerenteRepository.deleteById(id);
    }
}