package kr.co.jimmy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jimmy.DAO.MemberDAO;
import kr.co.jimmy.VO.MemberVO;

@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "form.jsp";
		String cmd = request.getParameter("cmd");
		
		cmd = cmd == null? "" : cmd;
		
		if("register".equals(cmd)) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String email = request.getParameter("email");
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(pw);
			vo.setEmail(email);
			
			MemberDAO dao = new MemberDAO();
			dao.MemberInsert(vo);
			
			url = "/list.jsp";
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
