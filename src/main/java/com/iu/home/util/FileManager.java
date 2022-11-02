package com.iu.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.home.board.BoardFileVO;

@Component
public class FileManager extends AbstractView{
	
	@Value("${app.download.base}")
	private String base;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BoardFileVO boardFileVO = (BoardFileVO)model.get("fileVO");
		String path = (String)model.get("path");
		
		File file = new File(base+path, boardFileVO.getFileName());
		
		//한글 처리
		response.setCharacterEncoding("UTF-8");
				
		//총 파일의 크기
		response.setContentLengthLong(file.length());
				
		//다운로드시 파일의 이름을 인코딩
		String oriName = URLEncoder.encode(boardFileVO.getOriName(), "UTF-8");
		
		//header 설정(부가정보를 알려주는 것)
		response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
				
		//HDD에서 파일을 읽고 
		FileInputStream fi = new FileInputStream(file);
		//Client로 전송 준비
		OutputStream os = response.getOutputStream();
				
		//전송(multipartFile이 없으므로 FileCopyUtils 사용)
		FileCopyUtils.copy(fi, os);
				
		//자원 해제(역순으로)
		os.close();
		fi.close();
		
	}

	public String saveFile(String path, MultipartFile multipartFile)throws Exception{
		//1. 중복되지 않는 파일명 생성
		String fileName = UUID.randomUUID().toString();
		
		//2. 파일명에 확장자 붙이기
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		
		//3. 원래 파일명에서 확장자명만 떼서 우리가 생성한 fileName에 붙이기
		String oriName = multipartFile.getOriginalFilename();
		oriName = oriName.substring(oriName.lastIndexOf("."));
		bf.append(oriName);
		fileName = bf.toString();
		
		//4. 파일 HDD에 저장하기
		File file = new File(path, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	//HDD에서 파일 삭제
	public boolean deleteFile(String path, BoardFileVO boardFileVO)throws Exception {
		File file = new File(path, boardFileVO.getFileName());
		return file.delete();
	}
}
