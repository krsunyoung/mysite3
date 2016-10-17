package com.bit2016.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2016.mysite.vo.UserVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //톰캣매니저에게 쿠키를 달라해 ?
		//id값과 물려있는.....
		
		if(session ==null){
			WebUtil.redirect(request, response, "/mysite3/main");
			return;
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser != null){
			//logout 처리
			session.removeAttribute("authUser");
			session.invalidate();// 새로운 세션값을 발급. 위에를 안해줘도 세션이 틀려져서 로그아웃이 되기는함. 메모리를 효율적으로 사용하기 위해 위를 날려줌.
		}
		
		
		WebUtil.redirect(request, response, "/mysite3/main");
	}

}
