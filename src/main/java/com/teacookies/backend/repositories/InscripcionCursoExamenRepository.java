package com.teacookies.backend.repositories;

import com.teacookies.backend.models.InscripcionCursoExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionCursoExamenRepository extends JpaRepository<InscripcionCursoExamen, Integer> {
}
