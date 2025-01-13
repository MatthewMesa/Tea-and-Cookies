package com.teacookies.backend.repositories;

import com.teacookies.backend.models.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicRepository extends JpaRepository<Epic, Integer> {
}
