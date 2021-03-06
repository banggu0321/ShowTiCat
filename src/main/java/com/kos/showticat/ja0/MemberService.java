package com.kos.showticat.ja0;

import com.kos.showticat.VO.MemberVO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	//로그인
	public MemberVO selectID(String m_id, String m_pw) {
		return dao.selectID(m_id, m_pw);
	}
	
	//아이디 찾기
	public MemberVO findID(String m_name, String phone) {
		return dao.findID(m_name, phone);
	}
	
	//비밀번호 찾기
	public MemberVO findPW(String m_id, String m_name, String phone) {
		return dao.findPW(m_id, m_name, phone);
	}
	
	//비밀번호 바꾸기
	public int resetPW(String m_id, String m_pw) {
		return dao.resetPW(m_id, m_pw);
	}

	//관심매장 변경
	public int updatePlace(int place_num, String m_id) {
		return dao.updatePlace(place_num, m_id);
	}
	
	//관심매장 삭제
	public int deletePlace(String m_id) {
		return dao.deletePlace(m_id);
	}
	
	//리뷰 작성 시 포인트 적립
	public int updatePoint(int point, String m_id) {
		return dao.updatePoint(point, m_id);
	}
	
	//ID 중복확인
	public int checkID(String m_id) {
		return dao.checkID(m_id);
	}
	
	//연락처 중복확인
	public int checkPhone(String phone) {
		return dao.checkPhone(phone);
	}
	
	//회원가입
	public int memberInsert(MemberVO member) {
		return dao.memberInsert(member);
	}
}
