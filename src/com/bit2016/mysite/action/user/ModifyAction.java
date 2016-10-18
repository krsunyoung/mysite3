package com.bit2016.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.UserDao;
import com.bit2016.mysite.vo.UserVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ModifyAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String password =request.getParameter("password");
		String gender =request.getParameter("gender");
		String email=request.getParameter("email");
		
		UserVo userVo = new UserVo();
//		userVo.setNo(authUser.getNo());
		userVo.setName(name);
		userVo.setName(password);
		userVo.setGender(gender);
		userVo.setEmail(email);
		
		new UserDao().update(userVo);
	WebUtil.redirect(request, response, "/mysite3/user?a=modifyform&update=success");
//	WebUtil.forward(request, response,
//				"WEB-INF/views/user/modifyform.jsp");
	}
	
}
