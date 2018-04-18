<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 가입</h1>
	<form action="list.jsp?cmd=register" method="get">
	<table>
		<tr>
			<td>
				ID
			</td>
			<td>
				<input type="text" name="id" value="">
			</td>
		</tr>	
		<tr>
			<td>
				PASSWORD
			</td>
			<td>
				<input type="text" name="pw" value="">
			</td>
		</tr>
		<tr>
			<td>
				Email address
			</td>
			<td>
				<input type="text" name="email" value="">
			</td>
		</tr>
		<tr>
		<td></td>
		<td style="text-align: right">
			<input type="submit" value="전송">
		</td>
		</tr>
	</table>
	</form>
	<p>
		<a href="list.jsp">리스트 바로가기</a>
	</p>
</body>
</html>