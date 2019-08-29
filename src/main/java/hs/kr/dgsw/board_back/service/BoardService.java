package hs.kr.dgsw.board_back.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

    List findAll();

    HashMap findById(Long id);
}
