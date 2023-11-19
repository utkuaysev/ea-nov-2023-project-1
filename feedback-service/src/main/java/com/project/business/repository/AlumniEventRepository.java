package com.project.business.repository;

import com.project.business.model.AlumniEvent;
import org.springframework.data.repository.ListCrudRepository;

public interface AlumniEventRepository extends ListCrudRepository<AlumniEvent, Long> {
    AlumniEvent findAlumniEventByAlumni_IdAndEvent_Id(long alumniId, long eventId);
}
