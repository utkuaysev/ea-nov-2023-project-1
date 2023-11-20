package com.project.event.model.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
public class AlumniEventId implements Serializable {
    private Long alumniId;
    private Long eventId;

    public AlumniEventId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumniEventId that = (AlumniEventId) o;
        return Objects.equals(alumniId, that.alumniId) &&
                Objects.equals(eventId, that.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumniId, eventId);
    }
}
