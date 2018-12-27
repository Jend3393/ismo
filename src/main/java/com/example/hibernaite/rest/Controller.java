package com.example.hibernaite.rest;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernaite.persistence.entity.Collaborator;
import com.example.hibernaite.persistence.entity.UserStory;
import com.example.hibernaite.persistence.repository.CollaboratorRepository;
import com.example.hibernaite.persistence.repository.UserStoryRepository;

import static com.example.hibernaite.persistence.enums.Fonction.ARCHITECT;
import static com.example.hibernaite.persistence.enums.Fonction.SCRUM_MASTER;
import static com.example.hibernaite.persistence.enums.Size.XL;
import static com.example.hibernaite.persistence.enums.Type.DEFECT;

@RestController
public class Controller {

    @Inject
    CollaboratorRepository repository;

    @Inject
    UserStoryRepository userStoryRepository;


    @Inject
    Validator validator;

    @PostConstruct
    @Transactional
    public void test() {

        Collaborator penan = Collaborator.builder().email("penan@gmail.com")
                                         .external(true)
                                         .firstName("penan")
                                         .lastName("dedy")
                                         .function(ARCHITECT)
                                         .build();

        Collaborator siaka = Collaborator.builder().email("siaka@gmail.com")
                                         .external(true)
                                         .firstName("siaka")
                                         .lastName("traoré")
                                         .function(SCRUM_MASTER)
                                         .build();

        Collaborator mehdi = Collaborator.builder().email("mehdi@gmail.com")
                                         .external(true)
                                         .firstName("mehdi")
                                         .lastName("chekini")
                                         .function(SCRUM_MASTER)
                                         .build();

        UserStory userStory = UserStory.builder().size(XL).sprintId(36L).type(DEFECT).developper(penan).build();

        List<Collaborator> devs = repository.findAll();
        int a = 5;

        //        repository.saveAll(Arrays.asList(penan, siaka, mehdi));
//        userStoryRepository.save(userStory);

    }

    @GetMapping
    @Transactional
    public String delete() {
        userStoryRepository.deleteById(1L);
        return "je supprime";
    }



    @PostMapping("/addCollaborator")
    public String add(@RequestBody Collaborator collaborator){


        Consumer jeconsomme = x -> System.out.println(x);

        Set<ConstraintViolation<Collaborator>> errors = validator.validate(collaborator);

        errors.stream().map(violation -> violation.getMessage()).forEach(jeconsomme);


        return "collaborator added with success";
    }
}
