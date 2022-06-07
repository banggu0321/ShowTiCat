package com.kos.showticat.jayoung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.util.DBUtil;

public class ShowDAO {
	static final String SQL_SELECT ="select * from show";
	static final String SQL_SELECT_CODE ="select * from show where show_code=?";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//공연목록 전체조회
	public List<ShowVO> selectAll() {
		List<ShowVO> showList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				showList.add(makeShow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
	
		return showList;
	}
	
	//공연코드로 조회
	public ShowVO selectShow(String show_code) {
		ShowVO show = new ShowVO();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CODE);
			pst.setString(1, show_code);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				show = makeShow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return show;
	}

	private ShowVO makeShow(ResultSet rs) throws SQLException {
		ShowVO show = new ShowVO();
		
		show.setCategory(rs.getString("category"));
		show.setDirector(rs.getString("director"));
		show.setOpening_date(rs.getDate("opening_date"));
		show.setPoster(rs.getString("poster"));
		show.setPrice(rs.getInt("price"));
		show.setShow_code(rs.getString("show_code"));
		show.setShow_name(rs.getString("show_name"));
		show.setShow_time(rs.getString("show_time"));
		show.setSummary(rs.getString("summary"));
		show.setTrailer(rs.getString("trailer"));
		
		return show;
	}
}