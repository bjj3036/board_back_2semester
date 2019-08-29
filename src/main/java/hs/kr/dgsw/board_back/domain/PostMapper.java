package hs.kr.dgsw.board_back.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PostMapper {
    Long insertPost(Post post);

    List orderByTime(SearchOption option);

    List orderByView(SearchOption option);

    List orderByRecommend(SearchOption option);

    int updatePost(Post post);

    List loadRecent();

    HashMap getById(Long id);

    void viewAdd(Long id);

    int recommendPost(Long id);

    Long deleteById(Long id);
}
