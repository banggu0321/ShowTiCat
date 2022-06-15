package com.kos.showticat.ja0;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kos.showticat.VO.ScheduleVO;
import com.kos.showticat.util.DBUtil;
import com.kos.showticat.util.DateUtil;

public class ScheduleDAO {
	static final String SQL_SELECT_ALL ="select * from schedule";
	static final String SQL_SELECT_BY_NUM ="select * from schedule where place_num =?";
	static final String SQL_SELECT_BY_SHOW ="select * from schedule where place_num =? and show_code=?";
	
	static final String SQL_SELECT_THEATER ="SELECT SHOW_CODE,SHOW_NAME,schedule_num,theater_num,s.place_num, show_start "
			+ " FROM schedule s JOIN show using(show_code) JOIN theater using(theater_num)"
			+ " where s.place_num=? and SHOW_START >= ? and SHOW_START < ? ORDER BY 2,4,6"; 
	
	static final String SQL_SELECT_IF_SYSDATE ="SELECT SHOW_CODE,SHOW_NAME,schedule_num,theater_num,s.place_num, show_start "
			+ " FROM schedule s JOIN show using(show_code) JOIN theater using(theater_num)"
			+ " where s.place_num=? and SHOW_START >= sysdate and SHOW_START < ? ORDER BY 2,4,6"; 
	
	static final String SQL_COUNT = "SELECT DISTINCT schedule_num , count(*) OVER(PARTITION BY schedule_num)"
			+ " FROM reservation JOIN reserv_detail using(reservation_num) JOIN SCHEDULE s USING(schedule_num)"
			+ " JOIN theater using(theater_num) WHERE pay_yn ='Y' AND s.place_num = ?";
	
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
	public List<ScheduleVO> selectByTheater(int place_num , Date show_date) {
		List<ScheduleVO> scheduleList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_THEATER);
			pst.setInt(1, place_num);
			pst.setDate(2, show_date); 
			pst.setDate(3, DateUtil.dayAfter(show_date));
			
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
	
	//상영관별로 조회(오늘)
	public List<ScheduleVO> selectByIfSysdate(int place_num) {
		List<ScheduleVO> scheduleList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_IF_SYSDATE);
			pst.setInt(1, place_num);
			pst.setDate(2, DateUtil.dayAfter(DateUtil.sysdate()));
			
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
	
	//예약된 좌석
	public Map<Integer, Integer> reservCnt(int place_num) {
		Map<Integer, Integer> cntList = new HashMap<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_COUNT);
			pst.setInt(1, place_num);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				cntList.put(rs.getInt(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return cntList;
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
