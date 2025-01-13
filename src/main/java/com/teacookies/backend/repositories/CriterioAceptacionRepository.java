package com.teacookies.backend.repositories;

import com.teacookies.backend.models.CriterioAceptacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterioAceptacionRepository extends JpaRepository<CriterioAceptacion, Integer> {
}
