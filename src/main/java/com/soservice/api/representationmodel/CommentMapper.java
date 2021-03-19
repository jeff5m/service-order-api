package com.soservice.api.representationmodel;

import com.soservice.api.representationmodel.models.comment.CommentPostRequest;
import com.soservice.api.representationmodel.models.comment.CommentResponse;
import com.soservice.domain.model.Comment;
import com.soservice.domain.service.ServiceOrderService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ServiceOrderService.class})
public interface CommentMapper {

    @Mapping(target = "sendDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "commentPostRequest.description", target = "description")
    @Mapping(source = "serviceOrderId", target = "serviceOrder")
    Comment from(CommentPostRequest commentPostRequest, Long serviceOrderId);

    CommentResponse toCommentResponse(Comment comment);

    List<CommentResponse> toListOfCommentsResponse(List<Comment> comments);
}
