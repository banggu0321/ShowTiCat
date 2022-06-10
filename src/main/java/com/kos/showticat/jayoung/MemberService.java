package com.kos.showticat.jayoung;

import java.util.List;

import com.kos.showticat.jayoung.MemberVO;

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

	// 개인정보 수정
	public int memberUpdate(MemberVO member) {
		return dao.memberUpdate(member);
	}

	// 포인트 확인
	public MemberVO memberPoint(String m_name, int point) {
		return dao.selectByPoint(m_name, point);
	}

	// 관심매장 확인 및 수정
	public MemberVO memberPlace(String m_name, String place) {
		return dao.selectByPlace(m_name, place);

	}

	// 예매 및 취소내역 확인

	// (리뷰)
	
	// 회원 탈퇴
	public int Delete(String m_id) {
		return dao.Delete(m_id);
	}

}