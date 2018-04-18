package kr.co.jimmy.VO;

public class MemberVO {

	private int no;
	private String id;
	private String pw;
	private String email;

	// 생성자
	public MemberVO() {
	}

	// 생성자
	public MemberVO(int no, String id, String pw, String email) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}

}