package com.iu.home.util;

import java.io.File;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.iu.home.board.BoardFileVO;

@Component
public class FileManager {
	
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
