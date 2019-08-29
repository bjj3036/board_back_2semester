package hs.kr.dgsw.board_back.service;

import hs.kr.dgsw.board_back.domain.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List findAll() {
        return boardMapper.findAll();
    }

    @Override
    public HashMap findById(Long id) {
        return boardMapper.findById(id);
    }
}
