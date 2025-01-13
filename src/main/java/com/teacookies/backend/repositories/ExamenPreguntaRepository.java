package com.teacookies.backend.repositories;

import com.teacookies.backend.models.ExamenPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenPreguntaRepository extends JpaRepository<ExamenPregunta, Integer> {
}
