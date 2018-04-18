package kr.co.jimmy.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.jimmy.VO.MemberVO;

public class MemberDAO {

	public void MemberInsert(MemberVO vo) {

		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String driver = "oracle.jdbc.OracleDriver";
		PreparedStatement pstmt = null;
		// ResultSet rs = null;
		int count = 0;
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(driver);
			// 2. Connection 얻어오기
			con = DriverManager.getConnection(url, "webdb", "1234");

			// 3. SQL문 준비
			String sql = "INSERT INTO member_tbl VALUES (user_no.nextval,?,?,?)";

			// 4. 바인딩
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getEmail());

			// 5. 실행
			count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.print("삽입 완료");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// rs.close(); // 종료
				pstmt.close(); // 종료
				con.close(); // 종료
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<MemberVO> searchAll() {

		ArrayList<MemberVO> list = null;
		MemberVO vo = null;
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String driver = "oracle.jdbc.OracleDriver";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			// 1. JDBC 드라이버 로딩
			Class.forName(driver);
			// 2. Connection 얻어오기
			con = DriverManager.getConnection(url, "webdb", "1234");
			// 3. SQL문 준비
			String sql = "SELECT * FROM member_tbl ORDER BY no DESC";

			// 4. 바인딩
			pstmt = con.prepareStatement(sql);
			// 5. 실행
			rs = pstmt.executeQuery();

			list = new ArrayList<MemberVO>();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setNo(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setPw(rs.getString(3));
				vo.setEmail(rs.getString(4));
				list.add(vo);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close(); // 종료
				pstmt.close(); // 종료
				con.close(); // 종료
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}