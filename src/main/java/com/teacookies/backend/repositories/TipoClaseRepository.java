package com.teacookies.backend.repositories;

import com.teacookies.backend.models.TipoClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoClaseRepository extends JpaRepository<TipoClase, Integer> {
}
