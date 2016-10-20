package com.bit2016.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.mysite.vo.BoardVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ModifyformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		
		BoardDao dao = new BoardDao();
		
		BoardVo boardvo = dao.get(Long.parseLong(no));
	
		
		//request 범위 모델데이터 저장
		request.setAttribute("vo", boardvo);
		WebUtil.forward(request, response, "/WEB-INF/views/board/modify.jsp");
		
		
	}

}
