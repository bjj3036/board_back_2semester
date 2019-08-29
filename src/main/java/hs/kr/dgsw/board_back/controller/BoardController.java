package hs.kr.dgsw.board_back.controller;

import hs.kr.dgsw.board_back.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/findAll")
    public List findAll() {
        return boardService.findAll();
    }

    @GetMapping("/find/{id}")
    public HashMap findByIdl(@PathVariable Long id) {
        return boardService.findById(id);
    }
}
