package com.soservice.api.controller;

import com.soservice.api.representationmodel.models.comment.CommentPostRequest;
import com.soservice.api.representationmodel.models.comment.CommentResponse;
import com.soservice.domain.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service-order/{serviceOrderId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<CommentResponse> listAll(@PathVariable Long serviceOrderId) {
        return commentService.listAllFromServiceOrder(serviceOrderId);
    }

    @PostMapping
    public ResponseEntity<CommentResponse> save(@PathVariable Long serviceOrderId,
                                                @Valid @RequestBody CommentPostRequest commentPostRequest) {
        return new ResponseEntity<>(commentService.addComment(serviceOrderId, commentPostRequest),
                HttpStatus.CREATED);
    }
}
