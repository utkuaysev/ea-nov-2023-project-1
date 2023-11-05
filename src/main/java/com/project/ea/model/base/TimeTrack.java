package com.project.ea.model.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class TimeTrack extends BaseClass {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
