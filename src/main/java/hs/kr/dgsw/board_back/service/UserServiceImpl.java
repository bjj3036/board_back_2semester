package hs.kr.dgsw.board_back.service;

import hs.kr.dgsw.board_back.domain.User;
import hs.kr.dgsw.board_back.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public HashMap login(User user) {
        HashMap loginInfo = userMapper.loginInfo(user.getId());
        HashMap returnLogin = new HashMap();
        if (loginInfo == null) {
            returnLogin.put("success", false);
            returnLogin.put("message", "존재하지 않는 아이디입니다");
        } else if (!loginInfo.get("password").equals(user.getPassword())) {
            returnLogin.put("success", false);
            returnLogin.put("message", "비밀번호가 일치하지 않습니다");
        } else {
            returnLogin.put("success", true);
            returnLogin.put("message", "로그인 성공");
            returnLogin.put("id", loginInfo.get("id"));
        }
        return returnLogin;
    }

    @Override
    public HashMap getUserInfo(String id) {
        return userMapper.getUserInfo(id);
    }

    @Override
    public boolean register(User user) {
        try {
            userMapper.add(user);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean confirmId(String id) {
        HashMap user = userMapper.getUserInfo(id);
        return user == null;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
