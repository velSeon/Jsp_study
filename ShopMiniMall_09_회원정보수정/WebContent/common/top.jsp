<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%
 MemberDTO  dto = (MemberDTO)session.getAttribute("login");
if(dto != null){
	String username = dto.getUsername();
%>
안녕하세요.<%=username %> 님.
 <a href="LogoutServlet">로그아웃</a>   
 <a href="MyPageServlet">mypage</a> 
 <a href="MemberUpdateServlet">회원정보수정</a>
 <%
}else{
 %>
<a href="loginForm.jsp">로그인</a>
<a href="MemberUIServlet">회원가입</a>
<a href="">장바구니</a>
<%
}
%>
