package com.kos.showticat.jaeyong;

import java.util.List;

import com.kos.showticat.jaeyong.MemberVO;

public class MemberService {
	MemberDAO dao = new MemberDAO();


	// 개인정보 수정
	public int memberUpdate(MemberVO member) {
		return dao.memberUpdate(member);
	}

//	// 포인트 확인
//	public MemberVO memberPoint(String m_name, int point) {
//		return dao.selectByPoint(m_name, point);
//	}

//	// 관심매장 확인 및 수정
//	public MemberVO memberPlace(String m_name, String place) {
//		return dao.selectByPlace(m_name, place);
//
//	}

	// 예매 및 취소내역 확인

	// (리뷰)
	
	// 회원 탈퇴
	public int Delete(String m_id) {
		return dao.Delete(m_id);
	}

}