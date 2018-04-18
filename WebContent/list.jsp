<%@page import="kr.co.jimmy.VO.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.jimmy.DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberVO> list = dao.searchAll();
	//System.out.print(list.toString());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<h1>회원가입 되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<!-- 메일정보 리스트 -->
	<%-- list에서 하나씩 빼서 테이블를 채운다--%>

	<%
		for (MemberVO vo : list) {
	%>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td align=right width="110">ID</td>
			<td width="170"><%=vo.getId()%></td>
		</tr>
		<tr>
			<td align=right>Password</td>
			<td><%=vo.getPw()%></td>
		</tr>
		<tr>
			<td align=right>Email</td>
			<td><%=vo.getEmail()%></td>
		</tr>
	</table>
	<br>
	<%
		}
	%>
	<a href="form.jsp">회원가입으로 가기</a>
</body>
</html>