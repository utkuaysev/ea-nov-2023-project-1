package com.project.ea.model;
import com.project.ea.model.base.BaseClass;
import com.project.ea.model.type.EventType;
import com.project.ea.model.type.ReportType;
import lombok.Getter;import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Where(clause = "isDeleted = false")
public class Report extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "report_type_id")
    private ReportType reportType;

    // Constructors can be omitted because Lombok generates them
}
