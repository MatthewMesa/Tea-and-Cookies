package com.teacookies.backend.repositories;

import com.teacookies.backend.models.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Integer> {
}
