package com.project.ea.dto.post;

import com.project.ea.model.Alumni;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFullFeedbackDto {
    private String description;
    private Alumni alumni;
}
