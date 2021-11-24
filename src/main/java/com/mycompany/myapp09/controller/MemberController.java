package com.mycompany.myapp09.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp09.model.service.MemberServiceImpl;

@Controller

public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberServiceImpl;
	
	@PostMapping("idCheck")
	public String idCheck(HttpServletResponse response, @RequestParam("id")String id) throws IOException {
		
		int result = 0;
		PrintWriter out = response.getWriter();
		result = memberServiceImpl.idCheck(id);
		
		String resultStr = "";
		try {
				if (result  == 0 ) {
					//아이디 중복일경우
					resultStr = "true";
					
				}else {
					//아이디 중복이 아닐경우
					resultStr = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("Controller return: " + resultStr);
		out.print(resultStr);
		out.flush();
		out.close();
		return "index";
	}
	

}
