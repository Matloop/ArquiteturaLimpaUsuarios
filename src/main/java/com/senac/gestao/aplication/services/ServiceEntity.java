package com.senac.gestao.aplication.services;

import java.util.List;
import java.util.Optional;

public interface ServiceEntity<T, ID> {
    T salvar(T entity);

    Optional<T> buscarPorId(ID id);

    List<T> listarTodos();

    void excluir(ID id);
}