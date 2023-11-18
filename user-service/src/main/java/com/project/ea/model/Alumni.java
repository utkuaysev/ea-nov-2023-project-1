package com.project.ea.model;
import com.project.ea.model.base.BaseClass;
import com.project.ea.model.type.RoleType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.List;

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

    @ManyToOne
    RoleType role;
}
