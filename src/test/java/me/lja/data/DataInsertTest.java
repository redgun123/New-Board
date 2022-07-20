package me.lja.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.lja.AppTest;
import me.lja.mapper.BoardMapper;
import me.lja.model.BoardVO;

public class DataInsertTest extends AppTest{
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void dataInsert() {
		
		for(int i =1; i <= 412; i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle("제목 : 페이징 처리 연습");
			vo.setContent("제목 : 페이징 처리 연습");
			vo.setWriter("관리자");
			mapper.insert(vo);
		}	
	}
}
