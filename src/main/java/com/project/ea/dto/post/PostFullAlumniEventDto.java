package com.project.ea.dto.post;

import com.project.ea.model.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullAlumniEventDto {
    private Event event;
    private boolean isAttended;
    private boolean isAccepted;
}
