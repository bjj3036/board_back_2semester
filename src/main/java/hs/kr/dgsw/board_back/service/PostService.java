package hs.kr.dgsw.board_back.service;

import hs.kr.dgsw.board_back.domain.Post;

import java.util.HashMap;
import java.util.List;

public interface PostService {
    Long insertPost(Post post);

    List loadPosts(Long board, String order, int page);

    List loadRecentPosts();

    HashMap getPostById(Long id);

    int recommendPost(Long id);

    Long deletePost(Long id);

    int updatePost(Post post);
}
