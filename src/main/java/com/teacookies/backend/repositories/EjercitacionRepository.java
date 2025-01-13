package com.teacookies.backend.repositories;

import com.teacookies.backend.models.Ejercitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercitacionRepository extends JpaRepository<Ejercitacion, Integer> {
}
