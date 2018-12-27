package com.example.hibernaite.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.hibernaite.persistence.enums.Size;
import com.example.hibernaite.persistence.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserStory {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long         id;
    private Long         sprintId;
    @Enumerated(STRING)
    private Size         size;
    @Enumerated(STRING)
    private Type         type;
    @ManyToOne(cascade = {PERSIST, REMOVE})
    @JoinColumn(name = "fk_developper")
    private Collaborator developper;
}
