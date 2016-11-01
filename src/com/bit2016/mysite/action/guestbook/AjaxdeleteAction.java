package com.bit2016.mysite.action.guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.GuestbookDao;
import com.bit2016.mysite.vo.GuestbookVo;
import com.bit2016.web.Action;

import net.sf.json.JSONObject;

public class AjaxdeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		
		GuestbookDao dao = new GuestbookDao();
		GuestbookVo vo = dao.get(Long.parseLong(no));
		
		
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("result", "success");
		if(vo == null){
			map.put("data", "not exist");
		}else {
			map.put("data", "exist");
		}
		
		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}
