package com.project.education.model;

import com.project.education.model.base.TimeTrack;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class EduExperience extends TimeTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long alumniId;

    private String university;

    @OneToMany(mappedBy = "eduExperience", cascade = CascadeType.ALL)
    private List<Course> courses;
    // Constructors can be omitted because Lombok generates them
}
