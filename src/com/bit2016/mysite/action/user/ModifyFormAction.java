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

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
//		UserVo userVo = new UserDao().get(authUser.getNo());
		UserVo userVo = new UserVo();
		
		userVo.setNo(10L);
		userVo.setName("sun");
		userVo.setGender("male");
		userVo.setEmail("aa@naver.com");
		
		
		request.setAttribute("userVo", userVo);
		
		WebUtil.redirect(request, response, "/mysite3/main");
		//WebUtil.forward(request, response, "/WEB-INF/views/user/modifyform.jsp");
		
	}

}
