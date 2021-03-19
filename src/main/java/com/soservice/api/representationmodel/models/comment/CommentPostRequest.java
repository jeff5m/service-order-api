package com.soservice.api.representationmodel.models.comment;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommentPostRequest {

    @NotBlank
    private String description;

}
