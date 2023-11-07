package com.project.ea.model;
import com.project.ea.model.base.TimeTrack;
import com.project.ea.model.type.EventType;
import lombok.Getter;import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "isDeleted = false")
public class Event extends TimeTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private EventType eventType;

    private String description;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<AlumniEvent> alumniEvents;
    // Constructors can be omitted because Lombok generates them
}
