package com.bit2016.mysite.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.vo.UserVo;

import net.sf.json.JSONArray;

@WebServlet("/ajax")
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8;");
		
		List<UserVo> list = new ArrayList<UserVo>();
		
		/* { 
		 	"name" : "sun",
		 	"message" : "hello"
		 } */
		UserVo vo1 = new UserVo();
		vo1.setNo(10L);
		vo1.setName("SS");
		vo1.setEmail("..@gmail.com");
		vo1.setGender("female");
		
		list.add(vo1);

		UserVo vo2 = new UserVo();
		vo2.setNo(20L);
		vo2.setName("둘리");
		vo2.setEmail("2@gmail.com");
		vo2.setGender("male");
		list.add(vo2);
		
		PrintWriter out = response.getWriter();

	//	JSONObject jsoObject=JSONObject.fromObject( list );
	//out.println(jsoObject.toString());
		JSONArray jsonArray=JSONArray.fromObject( list );
		out.println(jsonArray.toString());
		
/*		out.println(
				"{"+
				"  \"no\" : 10,  "+
				"  \"name\" : \"sun\",  "+
				"  \"message\" : \"hello\" "+
				"}"
				
				);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
