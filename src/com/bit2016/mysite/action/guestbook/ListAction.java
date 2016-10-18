package com.bit2016.mysite.action.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.GuestbookDao;
import com.bit2016.mysite.vo.GuestbookVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo>list = dao.getList();
		
		//request 범위 모델데이터 저장
		request.setAttribute("list", list);

		WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");
		//forwarding(request 연장, request dispatch)
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
//		rd.forward(request, response); //Attribute(list)가 request 로 온다. 그안에 저장시킴. 
		//집어 넣을때 setAttribute 뺄때 getAttribute
	}

}
