package com.project.business.dto.post;

import com.project.business.model.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullAlumniEventDto {
    private Event event;
    private boolean isAttended;
    private boolean isAccepted;
}
