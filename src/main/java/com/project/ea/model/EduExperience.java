package com.project.ea.model;

import com.project.ea.model.base.BaseClass;
import com.project.ea.model.base.TimeTrack;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "isDeleted = false")
public class EduExperience extends TimeTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degree;

    @OneToOne
    @JoinColumn(name = "alumni_id")
    private Alumni alumni;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @ManyToMany
    @JoinTable(
            name = "EduExperience_Course",
            joinColumns = { @JoinColumn(name = "edu_experience_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> courses;
    // Constructors can be omitted because Lombok generates them
}
