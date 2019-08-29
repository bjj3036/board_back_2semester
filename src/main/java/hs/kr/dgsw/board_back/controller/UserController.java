package hs.kr.dgsw.board_back.controller;

import hs.kr.dgsw.board_back.domain.User;
import hs.kr.dgsw.board_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    private HashMap login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/getInfo/{id}")
    private HashMap getUserInfo(@PathVariable String id) {
        return userService.getUserInfo(id);
    }

    @PostMapping("/register")
    private boolean register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/confirmId/{id}")
    private boolean confirmId(@PathVariable String id) {
        return userService.confirmId(id);
    }

    @PutMapping("/update")
    private int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
