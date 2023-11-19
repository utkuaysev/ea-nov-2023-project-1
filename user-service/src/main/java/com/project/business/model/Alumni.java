package com.project.business.model;
import com.project.business.model.base.BaseClass;
import com.project.business.model.type.RoleType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Where(clause = "is_deleted = false")
public class Alumni extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;
    private String password;
    private String phone;
    private String profilePicture;
    private String location;

    @ManyToOne
    RoleType role;
}
