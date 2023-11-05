package com.project.ea.model;
import com.project.ea.model.base.BaseClass;
import lombok.Getter;import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Where(clause = "isDeleted = false")
public class Feedback extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "alumni_id")
    private Alumni alumni;

    // Constructors can be omitted because Lombok generates them
}
