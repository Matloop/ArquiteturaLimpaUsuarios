package com.senac.gestao.domain.repositories;

import com.senac.gestao.domain.models.enums.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
