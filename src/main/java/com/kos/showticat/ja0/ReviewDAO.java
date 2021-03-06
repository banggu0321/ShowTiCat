package com.kos.showticat.ja0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.VO.ReviewVO;
import com.kos.showticat.util.DBUtil;

public class ReviewDAO {
	static final String SQL_SELECT = "select * from review join show using(show_code) where show_code=? ORDER BY 6 desc";
	static final String SQL_SELECT_REVIEW = "select * from review join show using(show_code) where review_num=? ";
	static final String SQL_INSERT = "insert into review values(seq_review_no.nextval,?,?,?,?,current_timestamp)";
	static final String SQL_SELECT_MYREVIEW = "select * from review join show using(show_code) where m_id=? ORDER BY 6 desc";
	static final String SQL_UPDATE_MYREVIEW = "update review set content = ?, grade = ? where review_num = ?";
	static final String SQL_DELETE_REVIEW = "delete from review where review_num = ?";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//영화/공연별
	public List<ReviewVO> selectAll(String show_code) {
		List<ReviewVO> reviewList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT);
			pst.setString(1, show_code);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				reviewList.add(makeReview(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
			
		return reviewList;
	}
	
	//리뷰
	public ReviewVO selectReview(int review_num) {
		ReviewVO review = new ReviewVO();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_REVIEW);
			pst.setInt(1, review_num);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				review = makeReview(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return review;
	}
	
	//리뷰등록
	public int insertReview(ReviewVO review) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_INSERT);
			pst.setString(1, review.getShow_code());
			pst.setString(2, review.getM_id());
			pst.setString(3, review.getContent());
			pst.setString(4, review.getGrade());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return result;
	}
	
	//id별
	public List<ReviewVO> selectMyReview(String m_id) {
		List<ReviewVO> reviewList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_MYREVIEW);
			pst.setString(1, m_id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				reviewList.add(makeReview(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return reviewList;
	}
	
	//리뷰수정
	public int updateMyReview(ReviewVO review) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE_MYREVIEW);
			pst.setString(1, review.getContent());
			pst.setString(2, review.getGrade());
			pst.setInt(3, review.getReview_num());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return result;
	}
	
	//리뷰삭제
	public int deleteMyReview(int review_num) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE_REVIEW);
			pst.setInt(1, review_num);
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return result;
	}

	private ReviewVO makeReview(ResultSet rs) throws SQLException {
		ReviewVO review = new ReviewVO();
		
		review.setContent(rs.getString("content"));
		review.setGrade(rs.getString("grade"));
		review.setM_id(rs.getString("m_id"));
		review.setReview_date(rs.getDate("review_date"));
		review.setReview_num(rs.getInt("review_num"));
		review.setShow_code(rs.getString("show_code"));
		review.setShow_name(rs.getString("show_name"));
		
		return review;
	}
}
