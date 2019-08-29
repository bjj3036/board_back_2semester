package hs.kr.dgsw.board_back.service;

import hs.kr.dgsw.board_back.domain.Attach;
import hs.kr.dgsw.board_back.domain.AttachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AttachServiceImpl implements AttachService {

    @Autowired
    AttachMapper attachMapper;

    @Override
    public HashMap findById(Long id) {
        return this.attachMapper.findById(id);
    }

    @Override
    public Long add(Attach attach) {
        this.attachMapper.add(attach);
        return attach.getId();
    }

    @Override
    public int modify(Attach attach) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }
}
