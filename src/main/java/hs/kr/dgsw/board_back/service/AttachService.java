package hs.kr.dgsw.board_back.service;


import hs.kr.dgsw.board_back.domain.Attach;

import java.util.HashMap;

public interface AttachService {
    HashMap findById(Long id);
    Long add(Attach attach);
    int modify(Attach attach);
    int deleteById(Long id);
}
