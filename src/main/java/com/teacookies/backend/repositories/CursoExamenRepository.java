package com.teacookies.backend.repositories;

import com.teacookies.backend.models.CursoExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoExamenRepository extends JpaRepository<CursoExamen, Integer> {
}
