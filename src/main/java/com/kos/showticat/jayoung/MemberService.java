package com.kos.showticat.jayoung;

import java.util.List;

public class MemberService {
	MemberDAO dao = new MemberDAO();

	// 로그인
	public MemberVO selectID(String m_id, String m_pw) {
		return dao.selectID(m_id, m_pw);
	}

	// 아이디 찾기
	public MemberVO findID(String m_name, String phone) {
		return dao.findID(m_name, phone);
	}

	// 비밀번호 찾기
	public MemberVO findPW(String m_id, String m_name, String phone) {
		return dao.findPW(m_id, m_name, phone);
	}

	// 비밀번호 바꾸기
	public int resetPW(String m_id, String m_pw) {
		return dao.resetPW(m_id, m_pw);
	}

	// ID 중복확인
	public int checkID(String m_id) {
		return dao.checkID(m_id);
	}

	// 회원가입
	public int memberInsert(MemberVO member) {
		return dao.memberInsert(member);
	}

}