package com.project.business.dto.post;

import com.project.business.model.type.EventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullEventDto {
private String description;
private EventType eventType;
}
