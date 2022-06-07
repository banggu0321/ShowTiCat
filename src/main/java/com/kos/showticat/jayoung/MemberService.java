package com.kos.showticat.jayoung;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	//로그?��
	public MemberVO selectID(String m_id, String m_pw) {
		return dao.selectID(m_id, m_pw);
	}
	
	//?��?��?�� 찾기
	public MemberVO findID(String m_name, String phone) {
		return dao.findID(m_name, phone);
	}
	
	//비�?번호 찾기
	public MemberVO findPW(String m_id, String m_name, String phone) {
		return dao.findPW(m_id, m_name, phone);
	}
	
	//비�?번호 바꾸�?
	public int resetPW(String m_id, String m_pw) {
		return dao.resetPW(m_id, m_pw);
	}
	
	//ID 중복?��?��
	public int checkID(String m_id) {
		return dao.checkID(m_id);
	}
	
	//?��?���??��
	public int memberInsert(MemberVO member) {
		return dao.memberInsert(member);
	}
}
