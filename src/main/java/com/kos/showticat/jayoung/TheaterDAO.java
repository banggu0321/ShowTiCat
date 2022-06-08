package com.kos.showticat.jayoung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.util.DBUtil;

public class TheaterDAO {
	static final String SQL_SELECT ="select * from theater where place_num=?";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//극장별 스케줄 조회
	public List<TheaterVO> selectByPlace(int place_num) {
		List<TheaterVO> theaterList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT);
			pst.setInt(1, place_num);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				theaterList.add(makeTheater(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
			
		return theaterList;
	}

	private TheaterVO makeTheater(ResultSet rs) throws SQLException {
		TheaterVO theater = new TheaterVO();
		
		theater.setLast_seat(rs.getInt("last_seat"));
		theater.setPlace_num(rs.getInt("place_num"));
		theater.setTheater_name(rs.getString(2));
		theater.setTheater_num(rs.getString("theater_num"));
		
		return theater;
	}
}
