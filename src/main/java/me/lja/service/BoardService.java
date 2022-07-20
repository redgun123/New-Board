package me.lja.service;

import java.util.List;

import me.lja.model.BoardVO;
import me.lja.model.Criteria;

public interface BoardService {
	
	List<BoardVO> readAll(Criteria criteria);
	BoardVO read(Long bno);
	void register(BoardVO vo);
	void modify(BoardVO vo);
	void remove(Long bno);
	Integer getTotal();
}
