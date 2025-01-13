package com.teacookies.backend.repositories;

import com.teacookies.backend.models.EstadoInscripcionCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoInscripcionCursoRepository extends JpaRepository<EstadoInscripcionCurso, Integer> {
}
