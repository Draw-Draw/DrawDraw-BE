package com.samtilee.drawdraw.comment.repository;

import com.samtilee.drawdraw.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
