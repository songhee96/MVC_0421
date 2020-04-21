package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageHandler implements CommandHandler {
	
	public String process(HttpServletRequest request,HttpServletResponse response) {
		
		
		
		return "/WEB-INF/view/login_page.jsp";
	}
	
	

}
