package com.project.ea.model;
import com.project.ea.model.base.BaseClass;
import lombok.Getter;import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class OpenJob extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime openDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Alumni creator;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "OpenJob_Alumni_Applications",
            joinColumns = @JoinColumn(name = "open_job_id"),
            inverseJoinColumns = @JoinColumn(name = "alumni_id"))
    private List<Alumni> applicants;
    // Constructors can be omitted because Lombok generates them
}
