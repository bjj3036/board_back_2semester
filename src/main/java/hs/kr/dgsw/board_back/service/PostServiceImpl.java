package hs.kr.dgsw.board_back.service;

import hs.kr.dgsw.board_back.domain.Post;
import hs.kr.dgsw.board_back.domain.PostMapper;
import hs.kr.dgsw.board_back.domain.SearchOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public Long insertPost(Post post) {
        return postMapper.insertPost(post);
    }

    @Override
    public List loadPosts(Long board, String order, int page) {
        SearchOption searchOption = new SearchOption();
        searchOption.setBoard(board);
        searchOption.setPage((page - 1) * 10);
        switch (order) {
            case "time":
                return postMapper.orderByTime(searchOption);
            case "view":
                return postMapper.orderByView(searchOption);
            case "recommend":
                return postMapper.orderByRecommend(searchOption);
        }
        return null;
    }

    @Override
    public List loadRecentPosts() {
        return postMapper.loadRecent();
    }

    @Override
    public HashMap getPostById(Long id) {
        postMapper.viewAdd(id);
        return postMapper.getById(id);
    }

    @Override
    public int recommendPost(Long id) {
        return postMapper.recommendPost(id);
    }

    @Override
    public Long deletePost(Long id) {
        return postMapper.deleteById(id);
    }

    @Override
    public int updatePost(Post post) {
        return postMapper.updatePost(post);
    }
}
