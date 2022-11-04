package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper {
	
	//로그인
	public MemberVO getLogin(String username)throws UsernameNotFoundException;
	
	//회원가입
	public int setJoin(MemberVO memberVO)throws Exception;

}
