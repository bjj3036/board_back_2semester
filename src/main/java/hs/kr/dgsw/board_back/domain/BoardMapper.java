package hs.kr.dgsw.board_back.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {

    List findAll();

    HashMap findById(Long id);

    List loadRecent();
}
