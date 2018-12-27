package com.example.hibernaite.persistence.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.hibernaite.persistence.enums.Fonction;
import com.example.hibernaite.constraints.annotations.CheckEmail;
import com.example.hibernaite.constraints.annotations.NotNullOrEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.example.hibernaite.persistence.enums.Errors.A02;
import static javax.persistence.EnumType.STRING;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NotNullOrEmpty
public class Collaborator {

    @Id
    @CheckEmail(error = A02, message = "daphneuné veut te remplacer")
    private String          email;
    private String          firstName;
    private String          lastName;
    private boolean         external;
    @Enumerated(STRING)
    private Fonction        function;
    @OneToMany(mappedBy = "developper", fetch = FetchType.LAZY)
    private List<UserStory> us;
}
