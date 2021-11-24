package com.mycompany.myapp09.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp09.member.model.vo.Member;




@Repository("memberDao")
public class MemberDAO {

	@Autowired
	private SqlSession sqlSessionTemplate;
	
	public int idCheck(String id) {
		int result = 0;
		String returnStr = "";
		
		System.out.println("dao arg:" + id);
		returnStr = sqlSessionTemplate.selectOne("MemberMapper.idCheck", id);
		
		if (returnStr == null) {
			result = 0;
		}else if(returnStr != null){
			result = 1;
		}
		
		System.out.println("dao return: "+ returnStr);
		return result;
	}

}
