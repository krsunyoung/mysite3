package com.bit2016.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2016.mysite.dao.UserDao;
import com.bit2016.mysite.vo.UserVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ModifyAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserVo vo = (UserVo)request.getAttribute("userVo");
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String password =request.getParameter("password");
		String gender =request.getParameter("gender");
		String email=request.getParameter("email");
		
		UserVo userVo = new UserVo();
		userVo.setNo(Long.parseLong(no));
		userVo.setName(name);
		userVo.setPassword(password);
		userVo.setGender(gender);
		userVo.setEmail(email);
		
		new UserDao().update(userVo);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo);
		
	WebUtil.redirect(request, response, "/mysite3/user?a=modifyform&update=success");
//	WebUtil.forward(request, response,
//				"WEB-INF/views/user/modifyform.jsp");
	}
	
}
