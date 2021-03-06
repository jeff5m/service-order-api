package com.soservice.domain.service;

import com.soservice.api.representationmodel.CommentMapper;
import com.soservice.api.representationmodel.models.comment.CommentPostRequest;
import com.soservice.api.representationmodel.models.comment.CommentResponse;
import com.soservice.domain.model.Comment;
import com.soservice.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final ServiceOrderService serviceOrderService;

    public List<CommentResponse> listAllFromServiceOrder(Long serviceOrderId) {
        List<Comment> comments = serviceOrderService.findAndReturnServiceOrderById(serviceOrderId).getComments();
        return commentMapper.toListOfCommentsResponse(comments);
    }

    public CommentResponse addComment(Long serviceOrderId, @Valid CommentPostRequest commentPostRequest) {
        Comment comment = commentMapper.from(commentPostRequest, serviceOrderId);
        comment.setSendDate(OffsetDateTime.now());
        return commentMapper.toCommentResponse(commentRepository.save(comment));
    }
}
