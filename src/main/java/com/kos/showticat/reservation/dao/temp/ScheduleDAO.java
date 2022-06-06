package com.kos.showticat.reservation.dao.temp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.reservation.vo.MembersVO;
import com.kos.showticat.reservation.vo.ScheduleVO;
import com.kos.showticat.util.DButil;

public class ScheduleDAO {
	
	final static String SQL_SCHEDULE_SELECT_ALL ="select schedule_num, show_code, theater_num, place_num, show_start from schedule";
	final static String SQL_SCHEDULE_POINT_SELECT_ALL ="select*from members";
	final static String SQL_SCHEDULE_POINT_UPDATE="";

	public List<MembersVO> selectALLMembers(){
		
		List<MembersVO> mvoList = new ArrayList<>();
		Connection con = DButil.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SCHEDULE_POINT_SELECT_ALL);
			
			while(rs.next()) {
				MembersVO mvo = new MembersVO();
				mvo.setmID(rs.getString("m_id"));
				mvo.setmPW(rs.getString("m_pw"));
				mvo.setmName(rs.getString("m_name"));
				mvo.setEmail(rs.getString("email"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setBirth(rs.getString("birth"));
				mvo.setGender(rs.getString("gender"));
				mvo.setmDate(rs.getString("m_date"));
				mvo.setPoint(rs.getString("point"));
				mvo.setPlaceNum(rs.getString("place_num"));
				mvoList.add(mvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return mvoList;	
	}
	
	
	public List<ScheduleVO> selectALL() {
		List<ScheduleVO> scdList = new ArrayList<>();
		
		Connection con = DButil.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SCHEDULE_SELECT_ALL);
			
			while(rs.next()) {
				ScheduleVO scvo = new ScheduleVO();
				scvo.setScheduleNum(String.valueOf(rs.getInt("schedule_num")));
				scvo.setShowCode(rs.getString("show_code"));
				scvo.setTheaterNum(rs.getString("theater_num"));
				scvo.setPlaceNum(String.valueOf(rs.getInt("place_num")));
				scvo.setShowStart(rs.getString("show_start"));
				scdList.add(scvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scdList;
	}

}
