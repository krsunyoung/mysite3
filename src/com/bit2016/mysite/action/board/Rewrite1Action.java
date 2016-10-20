package com.bit2016.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.mysite.dao.UserDao;
import com.bit2016.mysite.vo.BoardVo;
import com.bit2016.mysite.vo.UserVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class Rewrite1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		UserVo userVo=new UserDao().get(authUser.getNo());
		
		BoardDao dao = new BoardDao();
		
		String orderNo = request.getParameter("orderNo");
		String groupNo=request.getParameter("groupNo");
		String title = request.getParameter("title");
		String content=request.getParameter("content");
		String depth=request.getParameter("depth");
		
		BoardVo vo = new BoardVo();
		vo.setOrderNo(Integer.parseInt(orderNo));
		vo.setGroupNo(Integer.parseInt(groupNo));
		vo.setTitle(title);
		vo.setContent(content);
		vo.setDepth(Integer.parseInt(depth));
		vo.setUserNo(userVo.getNo());
		
		dao.reupdate(vo);
		
		dao.reinsert(vo);
		
		session.setAttribute("boardvo", vo);
		
		
		
		
		WebUtil.redirect(request,response,"/mysite3/board");
	}

}
