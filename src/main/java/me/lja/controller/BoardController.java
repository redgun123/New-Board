package me.lja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.lja.exception.NotFoundBoardException;
import me.lja.model.BoardVO;
import me.lja.model.Criteria;
import me.lja.model.PageMarker;
import me.lja.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	
	@GetMapping("/list")
	public String getList(Model model, Criteria criteria) {
		PageMarker pageMarker = new PageMarker(criteria, service.getTotal());
		List<BoardVO> readAll = service.readAll(criteria);
		model.addAttribute("pageMarker", pageMarker);
		model.addAttribute("list", readAll);
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Model model) {
		BoardVO read = service.read(bno);
		if(read==null) throw new NotFoundBoardException();
		model.addAttribute("board", service.read(bno));
		return "board/get";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		service.register(vo);
		rttr.addFlashAttribute("result", "register");
		rttr.addFlashAttribute("bno", vo.getBno());
		return "redirect:list";
	}
	
	@GetMapping("/modify")
	public String modifyForm(Long bno, Model model) {
		BoardVO read = service.read(bno);
		if(read==null) throw new NotFoundBoardException();
		model.addAttribute("board", read);
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modifyForm(BoardVO vo, RedirectAttributes rttr) {
		service.modify(vo);
		rttr.addFlashAttribute("result", "modify");
		rttr.addFlashAttribute("bno", vo.getBno());
		return "redirect:list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		service.remove(bno);
		rttr.addFlashAttribute("result", "remove")
			.addFlashAttribute("bno", bno);
		return "redirect:list";
	}
	
	// 예외처리
	@ExceptionHandler(NotFoundBoardException.class)
	public String notFoundBoard() {
		return "errorPage/notFoundBoard";
	}
}
