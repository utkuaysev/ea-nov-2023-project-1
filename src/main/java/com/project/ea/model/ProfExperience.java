package com.project.ea.model;
import com.project.ea.model.base.BaseClass;
import lombok.Getter;import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class ProfExperience extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startDate;
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "alumni_id")
    private Alumni alumni;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    // Constructors can be omitted because Lombok generates them
}
