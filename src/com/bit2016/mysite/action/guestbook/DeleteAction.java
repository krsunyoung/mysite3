package com.bit2016.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.GuestbookDao;
import com.bit2016.mysite.vo.GuestbookVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		Long no2 = Long.parseLong(no) ;	
		
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no2);
		vo.setPassword(password);
		
		GuestbookDao dao = new GuestbookDao();
		dao.delete(vo);
		
		WebUtil.redirect(request,response,"/guestbook2/gs");
		
	}

}
