package com.teacookies.backend.repositories;

import com.teacookies.backend.models.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Integer> {
}