package com.kos.showticat.jayoung;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	//ë¡œê·¸?¸
	public MemberVO selectID(String m_id, String m_pw) {
		return dao.selectID(m_id, m_pw);
	}
	
	//?•„?´?”” ì°¾ê¸°
	public MemberVO findID(String m_name, String phone) {
		return dao.findID(m_name, phone);
	}
	
	//ë¹„ë?ë²ˆí˜¸ ì°¾ê¸°
	public MemberVO findPW(String m_id, String m_name, String phone) {
		return dao.findPW(m_id, m_name, phone);
	}
	
	//ë¹„ë?ë²ˆí˜¸ ë°”ê¾¸ê¸?
	public int resetPW(String m_id, String m_pw) {
		return dao.resetPW(m_id, m_pw);
	}
	
	//ID ì¤‘ë³µ?™•?¸
	public int checkID(String m_id) {
		return dao.checkID(m_id);
	}
	
	//?šŒ?›ê°??…
	public int memberInsert(MemberVO member) {
		return dao.memberInsert(member);
	}
}
