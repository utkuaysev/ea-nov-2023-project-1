package com.project.ea.Repository;

import com.project.ea.model.Alumni;
import com.project.ea.model.AlumniEvent;
import com.project.ea.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {


}
