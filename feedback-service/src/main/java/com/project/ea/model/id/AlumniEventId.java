package com.project.ea.model.id;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
public class AlumniEventId implements Serializable {
    private Long alumniId;
    private Long eventId;
}
