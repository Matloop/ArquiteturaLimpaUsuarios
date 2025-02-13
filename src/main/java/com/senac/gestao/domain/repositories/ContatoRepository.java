package com.senac.gestao.domain.repositories;

import com.senac.gestao.domain.models.enums.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
