package com.kos.showticat.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.main.vo.ShowVO;
import com.kos.showticat.util.DBUtil;

public class TabShowDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;

	//chart 변경전
	static final String SQL_SELECT_CHART_MOVIE = ""
			+ "SELECT * "
			+ "FROM (SELECT rownum AS rownumber, o.*  "
			+ "		FROM (SELECT DISTINCT show_code, SHOW_NAME , POSTER, count(*) OVER(PARTITION BY show_code) "
			+ "				FROM show  	JOIN SCHEDULE using(show_code) "
			+ "							JOIN reservation using(schedule_num) "
			+ "							JOIN RESERV_DETAIL USING(reservation_num) "
			+ "				WHERE PAY_YN ='Y' "
			+ "				AND CATEGORY = '영화' "
			+ "				ORDER BY 4 desc) o ) r "
			+ " WHERE r.rownumber <= 2";
	static final String SQL_SELECT_CHART_PER = ""
			+ "SELECT * "
			+ "FROM (SELECT rownum AS rownumber, o.* "
			+ "		FROM (SELECT DISTINCT show_code, SHOW_NAME , POSTER, count(*) OVER(PARTITION BY show_code) "
			+ "				FROM show  	JOIN SCHEDULE using(show_code) "
			+ "							JOIN reservation using(schedule_num) "
			+ "							JOIN RESERV_DETAIL USING(reservation_num) "
			+ "				WHERE PAY_YN ='Y' "
			+ "				AND CATEGORY = '공연' "
			+ "				ORDER BY 4 desc) o ) r "
			+ " WHERE r.rownumber <= 2";
	static final String SQL_SELECT_SCREEN_MOVIE = ""
			+ "SELECT * "
			+ " FROM (SELECT rownum AS rownumber, o.* "
			+ "		FROM (SELECT * from SHOW s "
			+ "		WHERE CATEGORY = '영화' "
			+ "		AND OPENING_DATE > SYSDATE  "
			+ "		ORDER BY OPENING_DATE) o ) r "
			+ " WHERE r.rownumber <= 2 ";
	static final String SQL_SELECT_SCREEN_PER = ""
			+ "SELECT * "
			+ " FROM (SELECT rownum AS rownumber, o.* "
			+ "		FROM (SELECT * from SHOW s "
			+ "		WHERE CATEGORY = '공연' "
			+ "		AND OPENING_DATE > SYSDATE  "
			+ "		ORDER BY OPENING_DATE) o ) r "
			+ " WHERE r.rownumber <= 2 ";
	
	// 1. Chart
	// 1-1. Chart Movie
	public List<ShowVO> selectChartMovie() {
		List<ShowVO> showList = new ArrayList<ShowVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CHART_MOVIE);
			rs = pst.executeQuery();
			while(rs.next()) {
				ShowVO show = makeSlist(rs);
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showList;
	}
	// 1-2. Chart Performance
	public List<ShowVO> selectChartPer() {
		List<ShowVO> showList = new ArrayList<ShowVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CHART_PER);
			rs = pst.executeQuery();
			while(rs.next()) {
				ShowVO show = makeSlist(rs);
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showList;
	}
	// 2. Screen
	// 2-1. Screen Movie
	public List<ShowVO> selectScreenMovie() {
		List<ShowVO> showList = new ArrayList<ShowVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_SCREEN_MOVIE);
			rs = pst.executeQuery();
			while(rs.next()) {
				ShowVO show = makeSlist(rs);
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showList;
	}
	// 2-2. Screen Performance
	public List<ShowVO> selectScreenPer() {
		List<ShowVO> showList = new ArrayList<ShowVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_SCREEN_PER);
			rs = pst.executeQuery();
			while(rs.next()) {
				ShowVO show = makeSlist(rs);
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showList;
	}	
	
	private ShowVO makeSlist(ResultSet rs) throws SQLException {
		String show_code = null;
		String show_name = null;
		String poster = null;
		
		ShowVO s = new ShowVO(show_code, show_name, poster);
		s.setShow_code(rs.getString("SHOW_CODE"));
		s.setShow_name(rs.getString("SHOW_NAME"));
		s.setPoster(rs.getString("POSTER"));
		return s;
	}
}
