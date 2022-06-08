package com.kos.showticat.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.admin.vo.ShowVO;
import com.kos.showticat.util.DBUtil;

public class ShowDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	//SQL
	static final String SQL_SELECT_ALL = "SELECT SHOW_CODE , SHOW_NAME , OPENING_DATE , SHOW_TIME ,CATEGORY  FROM show";
	//static final String SQL_SELECT_SHOW_INSERT ="SELECT SHOW_CODE , SHOW_NAME FROM SHOW";
	//static final String SQL_SELECT_PLACE_INSERT ="SELECT PLACE_NUM , PLACE_NAME FROM PLACE";
	//static final String SQL_SELECT_THEATER_INSERT ="SELECT THEATER_NUM FROM THEATER";	
	static final String SQL_INSERT_SHOW ="INSERT INTO SHOW VALUES(?||SEQ_SHOW_NO.nextval,?,?,?,?,?,?,?,?,?)";
	static final String SQL_DELETE_SHOW ="DELETE FROM show WHERE show_code =? ";
	
	
	// 1. 모든 스케줄 조회
	public List<ShowVO> selectAllShow() {
		List<ShowVO> showlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pst.executeQuery();
			while(rs.next()) {
				showlist.add(makeslist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showlist;
	}
	private ShowVO makeslist(ResultSet rs) throws SQLException {
		ShowVO s = new ShowVO();
		s.setShow_code(rs.getString("SHOW_CODE"));
		s.setShow_name(rs.getString("SHOW_NAME"));
		s.setOpening_date(rs.getDate("OPENING_DATE"));
		s.setShow_time(rs.getInt("SHOW_TIME"));
		s.setCategory(rs.getString("CATEGORY"));
		return s;
	}
	
	// 2-2. 스케줄 추가
	public int insertShow(ShowVO sc) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_INSERT_SHOW);
			pst.setString(1, sc.getShow_code());
			pst.setString(2, sc.getShow_name());
			pst.setString(3, sc.getDirector());
			pst.setString(4, sc.getTrailer());
			pst.setDate(5, sc.getOpening_date());
			pst.setInt(6, sc.getShow_time());
			pst.setString(7, sc.getCategory());
			pst.setString(8, sc.getSummary());
			pst.setString(9, sc.getPoster());
			pst.setInt(10, sc.getPrice());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	/*
	// 3. 공연 수정
	public int updateShow(ShowVO sc){
		return 0;
	}
	// 4. 공연 삭제
	// 4-1. 해당 공연의 판매 횟수 조회 (조건조회)
	public int selectBuyShow() {
		return 0;
	}

	// 4-2. 공연 삭제
	public int deleteShow(int show_code) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE_SHOW);
			pst.setInt(1, show_code);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}
	*/
}
