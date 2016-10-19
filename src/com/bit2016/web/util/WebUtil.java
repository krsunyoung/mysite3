package com.bit2016.web.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	public static int checkIntParam(String s, int value){
		return
		(s != null &&s.matches("\\d*\\.?\\d+"))? Integer.parseInt(s): value;
		//java isNumeric 찾으면 나온다지만 뭔말이냐 대체!!!!!!!!!!!!!!!111
	}
	public static void forward (
		HttpServletRequest request,
		HttpServletResponse response,
		String path) throws ServletException, IOException {
		RequestDispatcher rd =
			request.getRequestDispatcher( path );
		rd.forward( request, response );
	}
	
	public static void redirect(
		HttpServletRequest request,
		HttpServletResponse response,
		String url)
		throws ServletException, IOException {
		response.sendRedirect( url );
	}
	
}
