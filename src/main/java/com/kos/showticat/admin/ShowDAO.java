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
	static final String SQL_INSERT_SHOW ="INSERT INTO SHOW VALUES(?||SEQ_SHOW_NO.nextval,?,?,?,?,?,?,?,?,?)";
	static final String SQL_SELECT_BYSHOW = "SELECT * FROM show";
	static final String SQL_UPDATE_SHOW ="UPDATE SHOW SET "
			+ " SHOW_NAME =?, "
			+ " DIRECTOR =?, "
			+ " TRAILER  =?, "
			+ " OPENING_DATE =?, "
			+ " SHOW_TIME =?, "
			+ " SUMMARY =?, "
			+ " POSTER =? "
			+ " WHERE SHOW_CODE = ? ";
	static final String SQL_SELECT_SCHEDULE_DELETE ="SELECT COUNT(SCHEDULE_NUM) FROM SCHEDULE WHERE SHOW_CODE = ?";	
	static final String SQL_DELETE_SHOW ="DELETE FROM show WHERE show_code =? ";
	
	
	// 1. 모든 스케줄 조회
	public List<ShowVO> selectAllShow() {
		List<ShowVO> showlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pst.executeQuery();
			while(rs.next()) {
				showlist.add(makesAlllist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showlist;
	}
	private ShowVO makesAlllist(ResultSet rs) throws SQLException {
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

	// 3. 공연 수정
	// 3-1. 해당 공연 조회
	public List<ShowVO> selectByCode(String show_code) {
		List<ShowVO> slist = new ArrayList<ShowVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYSHOW);
			pst.setString(1, show_code); //첫번째 ?에 부서번호를 넣는다.
			rs = pst.executeQuery();
			while(rs.next()) {
				slist.add(makeSlist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return slist;
	}
	private ShowVO makeSlist(ResultSet rs) throws SQLException {
		ShowVO s = new ShowVO();
		s.setShow_code(rs.getString("SHOW_CODE"));
		s.setShow_name(rs.getString("SHOW_NAME"));
		s.setDirector(rs.getString("DIRECTOR"));
		s.setTrailer(rs.getString("TRAILER"));
		s.setOpening_date(rs.getDate("OPENING_DATE"));
		s.setShow_time(rs.getInt("SHOW_TIME"));
		s.setCategory(rs.getString("CATEGORY"));
		s.setSummary(rs.getString("SUMMARY"));
		s.setPoster(rs.getString("POSTER"));
		s.setPrice(rs.getInt("PRICE"));
		return s;
	}
	// 3-2. 수정
	public int updateShow(ShowVO sc){
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE_SHOW);
			pst.setString(1, sc.getShow_name());
			pst.setString(2, sc.getDirector());
			pst.setString(3, sc.getTrailer());
			pst.setDate(4, sc.getOpening_date());
			pst.setInt(5, sc.getShow_time());
			pst.setString(6, sc.getSummary());
			pst.setString(7, sc.getPoster());
			pst.setString(8, sc.getShow_code());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}
	// 4. 공연 삭제
	// 4-1. 해당 공연의 판매 횟수 조회 (조건조회)
	public int selectBuyShow(String show_code) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_SCHEDULE_DELETE);
			pst.setString(1, show_code);  
			rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// 4-2. 공연 삭제
	public int deleteShow(String show_code) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE_SHOW);
			pst.setString(1, show_code);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}
}
