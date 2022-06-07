package com.kos.showticat.jayoung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.jayoung.DBUtil;

public class ScheduleDAO {
	static final String SQL_SELECT_ALL ="select * from schedule";
	static final String SQL_SELECT ="select * from schedule where place_num =? and show_code=?";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//? „ì²? ?Š¤ì¼?ì¤? ì¡°íšŒ
	public List<ScheduleVO> selectAll() {
		List<ScheduleVO> scheduleList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL);

			rs = pst.executeQuery();
			
			while(rs.next()) {
				scheduleList.add(makeSchedule(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return scheduleList;
	}
	
	//ê·¹ìž¥ë³„ë¡œ ì¡°íšŒ
	public List<ScheduleVO> selectByPlace(int place_num,String show_code) {
		List<ScheduleVO> scheduleList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT);
			pst.setInt(1, place_num);
			pst.setString(2, show_code);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				scheduleList.add(makeSchedule(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
	
		return scheduleList;
	}

	private ScheduleVO makeSchedule(ResultSet rs) throws SQLException {
		ScheduleVO schedule = new ScheduleVO();
		
		schedule.setPlace_num(rs.getInt("place_num"));
		schedule.setSchedule_num(rs.getInt("schedule_num"));
		schedule.setShow_code(rs.getString("show_code"));
		schedule.setShow_start(rs.getDate("show_start"));
		schedule.setTheater_num(rs.getString("theater_num"));
		
		return schedule;
	}
}
