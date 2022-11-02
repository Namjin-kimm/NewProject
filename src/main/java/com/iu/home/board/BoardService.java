package com.iu.home.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.board}")
	private String path;
	
	public List<BoardVO> getList(Pager pager)throws Exception{
		Long totalCount = boardMapper.getCount(pager);
		pager.getRowNum();
		pager.getNum(totalCount);
		
		List<BoardVO> ar = boardMapper.getList(pager);
		return ar;
	}
	
	public int setAdd(BoardVO boardVO)throws Exception{
		int result = boardMapper.setAdd(boardVO);
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		for(MultipartFile f: boardVO.getFiles()) {
			if(!f.isEmpty()) {
				BoardFileVO boardFileVO = new BoardFileVO();
				String fileName = fileManager.saveFile(path, f);
				boardFileVO.setFileName(fileName);
				boardFileVO.setNum(boardVO.getNum());
				boardFileVO.setOriName(f.getOriginalFilename());
				boardMapper.setAddFile(boardFileVO);
			}
		}
		
		return result;
	}

}
