package com.senac.gestao.domain.repositories;

import com.senac.gestao.domain.models.enums.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
