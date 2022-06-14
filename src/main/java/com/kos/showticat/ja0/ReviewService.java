package com.kos.showticat.ja0;

import java.util.List;

import com.kos.showticat.VO.ReviewVO;

public class ReviewService {
	ReviewDAO dao = new ReviewDAO();
	
	//영화/공연별
	public List<ReviewVO> selectAll(String show_code) {
		return dao.selectAll(show_code);
	}
	
	//리뷰
	public ReviewVO selectReview(int review_num) {
		return dao.selectReview(review_num);
	}
	
	//리뷰등록
	public int insertReview(ReviewVO review) {
		return dao.insertReview(review);
	}
	
	//id별
	public List<ReviewVO> selectMyReview(String m_id) {
		return dao.selectMyReview(m_id);
	}
	
	//리뷰수정
	public int updateMyReview(ReviewVO review) {
		return dao.updateMyReview(review);
	}
}
