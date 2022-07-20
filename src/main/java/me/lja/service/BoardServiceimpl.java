package me.lja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.lja.mapper.BoardMapper;
import me.lja.model.BoardVO;
import me.lja.model.Criteria;

@Service
public class BoardServiceimpl implements BoardService {

	private BoardMapper mapper;
	
	@Autowired
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<BoardVO> readAll(Criteria criteria) {
		return mapper.getList(criteria);
	}

	@Override
	public BoardVO read(Long bno) {
		return mapper.get(bno);
	}

	@Override
	public void register(BoardVO vo) {
		mapper.insert(vo);
	}

	@Override
	public void modify(BoardVO vo) {
		mapper.update(vo);
	}

	@Override
	public void remove(Long bno) {
		mapper.delete(bno);
	}

	@Override
	public Integer getTotal() {
		return mapper.totalCount();
	}
}
