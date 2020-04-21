package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.freeboard.model.MemberDao;

public class JoinMemberProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_nick = request.getParameter("m_nick");
		String m_phone = request.getParameter("m_phone");
		
		
		new MemberDao().insert(m_id, m_pw, m_nick, m_phone);
		
		
		
		return "/WEB-INF/view/join_member_scc.jsp";
	}

}
