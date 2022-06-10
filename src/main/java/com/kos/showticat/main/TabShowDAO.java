package com.kos.showticat.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.admin.vo.ShowVO;
import com.kos.showticat.util.DBUtil;

public class TabShowDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;

	static final String SQL_SELECT_CHART_MOVIE = "SELECT * FROM SHOW WHERE CATEGORY = '영화' ";
	static final String SQL_SELECT_CHART_PER = "SELECT * FROM SHOW WHERE CATEGORY = '공연'";
	static final String SQL_SELECT_SCREEN_MOVIE = ""
			+ "SELECT * "
			+ " FROM (SELECT * FROM SHOW "
			+ " WHERE CATEGORY = '영화' "
			+ " AND OPENING_DATE > SYSDATE "
			+ " ORDER BY OPENING_DATE)"
			+ " WHERE rownum <=2";
	static final String SQL_SELECT_SCREEN_PER = ""
			+ "SELECT * "
			+ " FROM (SELECT * FROM SHOW "
			+ " WHERE CATEGORY = '공연' "
			+ " AND OPENING_DATE > SYSDATE "
			+ " ORDER BY OPENING_DATE) "
			+ " WHERE rownum <=2";
	
	// 1-1. chart movie
	public List<ShowVO> selectChartMovie() {
		List<ShowVO> showlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CHART_MOVIE);
			rs = pst.executeQuery();
			while(rs.next()) {
				showlist.add(makeSlist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showlist;
	}
	// 1-2. chart performance
	public List<ShowVO> selectChartPer() {
		List<ShowVO> showlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CHART_PER);
			rs = pst.executeQuery();
			while(rs.next()) {
				showlist.add(makeSlist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showlist;
	}
	// 2-1. screen movie
	public List<ShowVO> selectScreenMovie() {
		List<ShowVO> showlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_SCREEN_MOVIE);
			rs = pst.executeQuery();
			while(rs.next()) {
				showlist.add(makeSlist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showlist;
	}
	// 2-2. screen performance
		public List<ShowVO> selectScreenPer() {
			List<ShowVO> showlist = new ArrayList<>();
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(SQL_SELECT_SCREEN_PER);
				rs = pst.executeQuery();
				while(rs.next()) {
					showlist.add(makeSlist(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbClose(rs, pst, conn);
			}
			return showlist;
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
}
