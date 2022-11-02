package com.iu.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.BoardFileVO;
import com.iu.home.board.BoardMapper;

@Controller
public class FileManagerController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@GetMapping("resources/down/{path}")
	public ModelAndView fileDown(@PathVariable String path, BoardFileVO boardFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(path.equals("board")) {
			boardFileVO = boardMapper.getFileDetail(boardFileVO);
		}
		
		mv.addObject("fileVO", boardFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		return mv;
	}

}
