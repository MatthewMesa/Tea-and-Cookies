package com.teacookies.backend.repositories;

import com.teacookies.backend.models.TipoPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPreguntaRepository extends JpaRepository<TipoPregunta, Integer> {
}
