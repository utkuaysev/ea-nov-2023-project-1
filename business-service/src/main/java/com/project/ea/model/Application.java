package com.project.ea.model;

import com.project.ea.model.id.ApplicationId;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Application {
    @EmbeddedId
    private ApplicationId id;

    @ManyToOne
    @MapsId("openJobId")
    private OpenJob openJob;
//    @MapsId("alumniId")
}

