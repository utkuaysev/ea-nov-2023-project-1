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

    // Constructors can be omitted because Lombok generates them
}
