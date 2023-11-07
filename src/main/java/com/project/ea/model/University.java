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
@Where(clause = "is_deleted = false")
public class University extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean  isDeleted;
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<EduExperience> eduExperiences;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Course> courses;
    // Constructors can be omitted because Lombok generates them
}
