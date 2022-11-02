package com.iu.home.board;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = boardService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("add")
	public void setAdd(@ModelAttribute BoardVO boardVO)throws Exception {
		
		
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(@Valid BoardVO boardVO, BindingResult bindingResult, RedirectAttributes redirectAttributes ,ModelAndView mv)throws Exception{
		if(bindingResult.hasErrors()) {
			log.info("============= 검증 Error ============");
			mv.setViewName("board/add");
			return mv;
		}
		int result = boardService.setAdd(boardVO);
		redirectAttributes.addAttribute("result", result);
		mv.setViewName("redirect:./list");
		return mv;
	}

}
