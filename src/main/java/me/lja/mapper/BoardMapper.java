package me.lja.mapper;

import java.util.List;

import me.lja.model.BoardVO;
import me.lja.model.Criteria;

public interface BoardMapper {
	
	List<BoardVO> getList(Criteria criteria);
	BoardVO get(Long bno);
	void insert(BoardVO vo);
	void update(BoardVO vo);
	void delete(Long bno);
	Integer totalCount();
}
