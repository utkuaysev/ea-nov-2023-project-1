package com.project.ea.model;
import com.project.ea.model.base.BaseClass;
import com.project.ea.model.base.TimeTrack;
import lombok.Getter;import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class ProfExperience extends TimeTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long alumni_id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    // Constructors can be omitted because Lombok generates them
}
