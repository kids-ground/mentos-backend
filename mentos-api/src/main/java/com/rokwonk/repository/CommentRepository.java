package com.rokwonk.repository;

import com.rokwonk.post.Comment;
import com.rokwonk.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
}
