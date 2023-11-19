package com.project.business.model;

import com.project.business.model.base.BaseClass;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class Address extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zip;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Company company;

    @OneToOne(mappedBy = "address")
    private University university;

    @OneToOne(mappedBy = "address")
    private Alumni alumni;
    // Constructors can be omitted because Lombok generates them
}