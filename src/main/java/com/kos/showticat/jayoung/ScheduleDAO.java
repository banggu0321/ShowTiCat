package com.kos.showticat.jayoung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.util.DBUtil;

public class ScheduleDAO {
	static final String SQL_SELECT_ALL ="select * from schedule";
	static final String SQL_SELECT_BY_NUM ="select * from schedule where place_num =?";
	static final String SQL_SELECT_BY_SHOW ="select * from schedule where place_num =? and show_code=?";
	static final String SQL_SELECT_THEATER ="SELECT SHOW_CODE, SHOW_NAME,schedule_num,theater_num,place_num, show_start FROM schedule "
			+ " JOIN show using(show_code) WHERE theater_num in ("
			+ "	SELECT theater_num FROM theater	WHERE place_num IN ("
			+ " SELECT place_num FROM place WHERE place_num = ?)) order by 2,4,6";
	static final String SQL_SYSDATE = "SELECT sysdate, sysdate+1, sysdate+2, sysdate+3, sysdate+4, SYSDATE+5, sysdate+6 FROM dual";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//전체 스케줄 조회
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
	
	//극장별로 조회
	public List<ScheduleVO> selectByPlace(int place_num) {
		List<ScheduleVO> scheduleList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BY_NUM);
			pst.setInt(1, place_num);
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
	
	//영화별로 조회
	public List<ScheduleVO> selectByShow(int place_num, String show_code) {
		List<ScheduleVO> scheduleList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BY_SHOW);
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

	//상영관별로 조회
	public List<ScheduleVO> selectByTheater(int place_num) {
		List<ScheduleVO> scheduleList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_THEATER);
			pst.setInt(1, place_num);
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
	
	//오늘 기준 7일 조회
	public DateVO selectSysdate() {
		DateVO dateList = new DateVO();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SYSDATE);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				dateList = makeDate(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return dateList;
	}

	private DateVO makeDate(ResultSet rs) throws SQLException {
		DateVO date = new DateVO();
		
		date.setSysdate(rs.getDate(1));
		date.setSysdate_1(rs.getDate(2));
		date.setSysdate_2(rs.getDate(3));
		date.setSysdate_3(rs.getDate(4));
		date.setSysdate_4(rs.getDate(5));
		date.setSysdate_5(rs.getDate(6));
		date.setSysdate_6(rs.getDate(7));
		
		return date;
	}

	private ScheduleVO makeSchedule(ResultSet rs) throws SQLException {
		ScheduleVO schedule = new ScheduleVO();
		
		schedule.setPlace_num(rs.getInt("place_num"));
		schedule.setSchedule_num(rs.getInt("schedule_num"));
		schedule.setShow_code(rs.getString("show_code"));
		schedule.setShow_name(rs.getString("show_name"));
		schedule.setShow_start(rs.getDate("show_start"));
		schedule.setTheater_num(rs.getString("theater_num"));
		schedule.setStart_time(rs.getTime("show_start"));
		
		return schedule;
	}
}
