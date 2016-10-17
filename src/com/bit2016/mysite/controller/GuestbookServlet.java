package com.bit2016.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.action.guestbook.GuestbookActionFactory;
import com.bit2016.web.Action;
import com.bit2016.web.ActionFactory;

@WebServlet("/gs")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String actionName = request.getParameter("a");
		
		ActionFactory af = new GuestbookActionFactory();
		Action action = af.getAction(actionName);
		action.execute(request, response);
		/*if("deleteform".equals(actionName)){
			//form 요청에 대한 처리
		
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
			
		}else if ("insert".equals(actionName)){
			
			//insert 요청에 대한 처리
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			String password = request.getParameter("password");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setContent(content);
			vo.setPassword(password);
			
			GuestbookDao dao = new GuestbookDao();
			dao.insert(vo);
			
			//자신에게 request
			response.sendRedirect("/guestbook2/gs");
			
		}else if ("delete".equals(actionName)){
			
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			Long no2 = Long.parseLong(no) ;	
			
			GuestbookVo vo = new GuestbookVo();
			vo.setNo(no2);
			vo.setPassword(password);
			
			GuestbookDao dao = new GuestbookDao();
			dao.delete(vo);
			
			response.sendRedirect("/guestbook2/gs");
			
		}else{
			//default action 처리(리스트 처리)
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo>list = dao.getList();
			
			//request 범위 모델데이터 저장
			request.setAttribute("list", list);
	
			
			//forwarding(request 연장, request dispatch)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response); //Attribute(list)가 request 로 온다. 그안에 저장시킴. 
			//집어 넣을때 setAttribute 뺄때 getAttribute
			
		}
		
		 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
