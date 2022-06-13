package com.kos.showticat.ja0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.VO.ReservationVO;
import com.kos.showticat.util.DBUtil;

public class ReservationDAO {
	static final String SQL_SELECT_ALL ="select * from reservation where m_id = ?";
	static final String SQL_DELETE ="update reservation set pay_yn = 'N' where reservation_num = ?";

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//예약목록
	public List<ReservationVO> selectAll(String m_id) {
		List<ReservationVO> reservationList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL);
			pst.setString(1, m_id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				reservationList.add(makeReservation(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return reservationList;
	}

	private ReservationVO makeReservation(ResultSet rs) throws SQLException {
		ReservationVO reservation = new ReservationVO();
		
		reservation.setM_id(rs.getString("m_id"));
		reservation.setPay_yn(rs.getString("pay_yn"));
		reservation.setPayment(rs.getString("payment"));
		reservation.setReservation_date(rs.getDate("reservation_date"));
		reservation.setReservation_num(rs.getInt("reservation_num"));
		reservation.setSchedule_num(rs.getInt("schedule_num"));
		reservation.setTotal_price(rs.getInt("total_price"));

		return reservation;
	}
}
