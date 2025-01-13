package com.teacookies.backend.repositories;

import com.teacookies.backend.models.InscripcionCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionCursoRepository extends JpaRepository<InscripcionCurso, Integer> {
}
