package com.mycompany.myapp09.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp09.model.dao.MemberDAO;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	public int idCheck(String id) {
		return memberDao.idCheck(id);
	}
	
}
