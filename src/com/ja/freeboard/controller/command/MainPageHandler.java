package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.freeboard.model.*;
import com.ja.freeboard.vo.*;
import java.util.*;

public class MainPageHandler implements CommandHandler { 

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<ContentDataVo> contentList =
				new ArrayList<ContentDataVo>();
		
		ArrayList<BoardVo> boardList = new BoardDao().selectAll();
		
		MemberDao memberDao =  new MemberDao();
		
		for(BoardVo boardVo : boardList) {
			
			MemberVo memberVo = memberDao.selectByNo(boardVo.getM_no());
			
			
			ContentDataVo contentDataVo = new ContentDataVo(memberVo,boardVo);
			
			
			contentList.add(contentDataVo);
		}
		request.setAttribute("contentList", contentList);
		
	
		
		
		return "/WEB-INF/view/main_page.jsp";
	}

}
