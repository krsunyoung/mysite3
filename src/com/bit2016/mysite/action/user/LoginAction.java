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

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		
		UserDao dao = new UserDao();
		UserVo vo = dao.get(email, password);
		
		//로그인 실패(password 또는 email 틀릴경우)
		if(vo ==null){
			//실패 처리는 리다이렉션
			WebUtil.redirect(request, response, "/mysite3/user?a=loginform&result=fail");
			return; //주의 : rdirect 를 한후 다음 코드가 실행 되지 않도록 함수 종료 
			//없으면 밑에 것이 실행되기 때문에 오류남.
		}
		
		//로그인이 성공 했을때 -> 인증처리
		HttpSession session = request.getSession(true); //없으면 null을 입력해줌
		//true를 입력해주었을경우에는 null이 안나온다 jsessionin와 연결된 session 객체가 없으면 만들어서 리턴
		// false or 빈 파라미터 -> jsessionid 와 연결된 session 객체가 없으면 null 리턴
		session.setAttribute("authUser", vo);
		
		WebUtil.redirect(request, response, "/mysite3/main");
	}

}
