package com.teacookies.backend.repositories;

import com.teacookies.backend.models.InscripcionCursoExamenPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionCursoExamenPreguntaRepository extends JpaRepository<InscripcionCursoExamenPregunta, Integer> {
}
