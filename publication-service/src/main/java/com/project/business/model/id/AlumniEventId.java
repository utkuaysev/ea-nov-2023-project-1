package com.project.business.model.id;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class AlumniEventId implements Serializable {
    private Long alumniId;
    private Long eventId;
}
