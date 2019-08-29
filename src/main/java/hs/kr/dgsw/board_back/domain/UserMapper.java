package hs.kr.dgsw.board_back.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface UserMapper {

    HashMap loginInfo(String id);

    void add(User user);

    HashMap getUserInfo(String id);

    int updateUser(User user);
}
