package com.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SetScopeServlet")
public class SetScopeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request scope에 저장//한번 응답이 이루어지면 request는 삭제됨
		request.setAttribute("request", "홍길동");//key:값(문자, 객체, arraylist등 넣을 수 있음)
		
		//session scope에 저장 // 브라우저 주기
		HttpSession session = request.getSession();//세션 얻기(브라우저(사용자)당 생기는 유일한 객체)
		session.setAttribute("session", "이순신"); //
		
		//application scope에 저장 //context주기
		ServletContext ctx = getServletContext(); //서버가 떠있는 동안, 
		ctx.setAttribute("application", "유관순");
		
		System.out.println("request: 홍길동");
		System.out.println("session: 이순신");
		System.out.println("application: 유관순");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
