package com.project.ea.dto.post;

import com.project.ea.model.type.EventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullEventDto {
private String description;
private EventType eventType;
}
