package com.soservice.api.representationmodel.models.comment;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class CommentResponse {

    private Long id;
    private String description;
    private OffsetDateTime sendDate;

}
