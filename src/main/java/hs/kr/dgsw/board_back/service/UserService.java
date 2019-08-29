package hs.kr.dgsw.board_back.service;

import hs.kr.dgsw.board_back.domain.User;

import java.util.HashMap;

public interface UserService {
    HashMap login(User user);

    HashMap getUserInfo(String id);

    boolean register(User user);

    boolean confirmId(String id);

    int updateUser(User user);
}
