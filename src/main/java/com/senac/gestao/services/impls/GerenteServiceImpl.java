package com.senac.gestao.services.impls;

import com.senac.gestao.models.Gerente;
import com.senac.gestao.repositories.GerenteRepository;
import com.senac.gestao.services.ServiceEntity;
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