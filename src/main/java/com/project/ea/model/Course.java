package com.project.ea.model;

import com.project.ea.model.base.BaseClass;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "isDeleted = false")
public class Course extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int code;
    private String description;

    @ManyToMany(mappedBy = "courses")
    private List<EduExperience> eduExperiences;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
    // Constructors can be omitted because Lombok generates them
}
