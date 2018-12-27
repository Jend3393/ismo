package com.example.hibernaite.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibernaite.persistence.entity.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, String> {


    List<Collaborator> findAllByFirstName(String firstName);

}
