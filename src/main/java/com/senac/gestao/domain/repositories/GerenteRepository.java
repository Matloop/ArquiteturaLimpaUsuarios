package com.senac.gestao.domain.repositories;

import com.senac.gestao.domain.models.enums.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {
}
