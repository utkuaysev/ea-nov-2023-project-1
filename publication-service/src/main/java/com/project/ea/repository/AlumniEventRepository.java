package com.project.ea.repository;

import com.project.ea.dto.get.GetFullEventDto;
import com.project.ea.dto.post.PostFullAlumniEventDto;
import com.project.ea.model.AlumniEvent;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AlumniEventRepository extends ListCrudRepository<AlumniEvent, Long> {
    AlumniEvent findAlumniEventByAlumni_IdAndEvent_Id(long alumniId, long eventId);
}
