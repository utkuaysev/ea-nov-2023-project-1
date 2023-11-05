package com.project.ea.model;

import com.project.ea.model.base.BaseClass;
import com.project.ea.model.id.AlumniEventId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Where(clause = "isDeleted = false")
public class AlumniEvent extends BaseClass {
    @EmbeddedId
    private AlumniEventId id;

    @MapsId("alumniId")
    @ManyToOne
    private Alumni alumni;

    @MapsId("eventId")
    @ManyToOne
    private Event event;

    private boolean isAttended;
    private boolean isAccepted;

    // Constructors can be omitted because Lombok generates them
}
