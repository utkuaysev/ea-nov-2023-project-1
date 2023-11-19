package com.project.business.model.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ApplicationId implements Serializable {
    private Long openJobId;

    private Long  alumniId;
}
