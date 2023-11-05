package com.project.ea.model;

import com.project.ea.model.base.BaseClass;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "isDeleted = false")

public class Company extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String industry;
    private String location;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<ProfExperience> profExperiences;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<OpenJob> openJobs;
    // Constructors can be omitted because Lombok generates them
}
