package com.example.hibernaite.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibernaite.persistence.entity.UserStory;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
}
