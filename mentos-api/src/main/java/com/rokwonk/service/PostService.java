package com.rokwonk.service;


import com.rokwonk.dto.request.CommentWriteRequest;
import com.rokwonk.dto.request.PostListRequest;
import com.rokwonk.dto.request.PostWriteRequest;
import com.rokwonk.dto.response.*;
import com.rokwonk.member.Member;
import com.rokwonk.post.Comment;
import com.rokwonk.post.Post;
import com.rokwonk.repository.CommentRepository;
import com.rokwonk.repository.MemberRepository;
import com.rokwonk.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public PostWriteResponse createPost(Long memberId, PostWriteRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
        Post newPost = Post.builder()
                .member(member)
                .title(request.title())
                .tags(String.join(",",request.tags()))
                .description(request.description())
                .build();
        postRepository.save(newPost);
        return new PostWriteResponse(newPost.getId());
    }

    @Transactional
    public PostListResponse getPostList(PostListRequest request) {
        List<Post> postList = postRepository.findAll();
        List<PostResponse> postResponseList = postList.stream()
                .map((post) -> new PostResponse(post))
                .collect(Collectors.toList());

        return new PostListResponse(postResponseList);
    }

    @Transactional
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(RuntimeException::new);
        int hit = 0;
        if (post.getHit() != null) hit = post.getHit() + 1;
        post.setHit(hit);
        return new PostResponse(post);
    }

    @Transactional
    public CommentWriteResponse createComment(Long memberId, Long postId, CommentWriteRequest request) {
        Post post = postRepository.findById(postId).orElseThrow(RuntimeException::new);
        Member member = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
        Member taggedMember = null;
        if (request.taggingMemberId() != null)
            taggedMember = memberRepository.findById(request.taggingMemberId()).orElse(null);

        Comment comment = Comment.builder()
                .post(post)
                .writer(member)
                .taggedMember(taggedMember)
                .content(request.content())
                .build();

        commentRepository.save(comment);
        int commentCount = 0;
        if (post.getCommentCount() != null) commentCount = post.getCommentCount() + 1;
        else commentCount = 1;

        post.setCommentCount(commentCount);
        return new CommentWriteResponse(comment.getId());
    }

    @Transactional
    public CommentListResponse getCommentList(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(RuntimeException::new);
        List<Comment> commentList = commentRepository.findAllByPost(post);

        return new CommentListResponse(
                commentList.stream()
                        .map(comment -> new CommentResponse(comment))
                        .collect(Collectors.toList())
        );
    }
}
