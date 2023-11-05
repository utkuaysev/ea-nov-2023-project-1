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
@Where(clause = "isDeleted = false")
public class Alumni extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;
    private String password;
    private String phone;
    private String profilePicture;

    @OneToOne(mappedBy = "alumni", cascade = CascadeType.ALL)
    private EduExperience eduExperience;

    @OneToMany(mappedBy = "alumni", cascade = CascadeType.ALL)
    private List<ProfExperience> profExperiences;

    @OneToMany(mappedBy = "creator")
    private List<OpenJob> createdOpenJobs;

    @OneToMany(mappedBy = "alumni")
    private List<AlumniEvent> alumniEvents;

    @OneToMany(mappedBy = "alumni", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @ManyToMany(mappedBy = "applicants")
    private List<OpenJob> applications;
}
