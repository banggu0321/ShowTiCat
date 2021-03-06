package com.kos.showticat.mypage.confirm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.mypage.confirm.vo.ConfirmVO;
import com.kos.showticat.mypage.confirm.vo.ReservDetailVO;
import com.kos.showticat.util.DBUtil;

public class ConfirmDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();
	Date date = java.sql.Date.valueOf(localDate);
	Time time = java.sql.Time.valueOf(localTime);
	
	static final String SQL_SELECT_ALL_RESERVATION = ""
			+ "SELECT * FROM RESERVATION r JOIN SCHEDULE sc ON (r.SCHEDULE_NUM = sc.SCHEDULE_NUM ) "
			+ "							JOIN THEATER t ON (t.THEATER_NUM=sc.THEATER_NUM) "
			+ "							JOIN PLACE p ON (p.PLACE_NUM=sc.PLACE_NUM) "
			+ "							JOIN SHOW s ON (s.SHOW_CODE=sc.SHOW_CODE) " + " WHERE r.M_ID = ? "
			+ " ORDER BY sc.SHOW_START ";
	static final String SQL_SELECT_DETAIL_RESERVATION = ""
			+ "SELECT * FROM RESERVATION r JOIN SCHEDULE sc ON (r.SCHEDULE_NUM = sc.SCHEDULE_NUM ) "
			+ "							JOIN THEATER t ON (t.THEATER_NUM=sc.THEATER_NUM) "
			+ "							JOIN PLACE p ON (p.PLACE_NUM=sc.PLACE_NUM) "
			+ "							JOIN SHOW s ON (s.SHOW_CODE=sc.SHOW_CODE) " + " WHERE r.RESERVATION_NUM = ? ";
	static final String SQL_SELECT_SEATNUM_RESERVATION = ""
			+ " SELECT * FROM RESERVATION r JOIN RESERV_DETAIL rd ON (r.RESERVATION_NUM=rd.RESERVATION_NUM) "
			+ " WHERE r.RESERVATION_NUM = ? ";
	static final String SQL_SELECT_CHECK_SHOW_RESERVATION = ""
			+ " SELECT * FROM SCHEDULE s JOIN RESERVATION r ON (r.SCHEDULE_NUM =s.SCHEDULE_NUM) "
			+ " WHERE s.SHOW_START - 1 > CURRENT_TIMESTAMP " 
			+ " AND r.RESERVATION_NUM = ? ";
	static final String SQL_SELECT_CHECK_MOVIE_RESERVATION = ""
			+ " SELECT * FROM SCHEDULE s JOIN RESERVATION r ON (r.SCHEDULE_NUM =s.SCHEDULE_NUM) "
			+ " WHERE s.SHOW_START - 1/24*0.5 > CURRENT_TIMESTAMP "
			+ " AND r.RESERVATION_NUM = ? ";
	static final String SQL_UPDATE_RESERVATION = "UPDATE RESERVATION SET PAY_YN = 'N' WHERE RESERVATION_NUM = ? ";
	static final String SQL_DELETE_SEAT = "DELETE FROM RESERV_DETAIL WHERE RESERVATION_NUM  = ? ";

	// 1. ????????????
	// 1-1-1 ??????
	public List<ConfirmVO> selectAllReservation(String m_id) {
		List<ConfirmVO> resevationlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL_RESERVATION);
			pst.setString(1, m_id); 
			rs = pst.executeQuery();
			while (rs.next()) {
				ConfirmVO res = makesAlllist(rs);
				resevationlist.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return resevationlist;
	}

	// 1-1-2 Detail RESERVATION_NUM
	public ConfirmVO selectDetailReservation(int reservation_num) {
		ConfirmVO resevationdetaillist = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_DETAIL_RESERVATION);
			pst.setInt(1, reservation_num); 
			rs = pst.executeQuery();
			while (rs.next()) {
				resevationdetaillist = makesAlllist(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return resevationdetaillist;
	}

	private ConfirmVO makesAlllist(ResultSet rs) throws SQLException {
		ConfirmVO c = new ConfirmVO();
		c.setM_id(rs.getString("M_ID"));
		c.setReservation_num(rs.getString("RESERVATION_NUM"));
		c.setReservation_date(rs.getDate("RESERVATION_DATE"));
		c.setSchedule_num(rs.getInt("SCHEDULE_NUM"));
		c.setShow_code(rs.getString("SHOW_CODE"));
		c.setShow_name(rs.getString("SHOW_NAME"));
		c.setCategory(rs.getString("CATEGORY"));
		c.setPrice(rs.getInt("PRICE"));
		c.setShow_start_date(rs.getDate("SHOW_START"));
		c.setShow_start_time(rs.getTime("SHOW_START"));
		c.setPlace_num(rs.getInt("PLACE_NUM"));
		c.setPlace_name(rs.getString("PLACE_NAME"));
		c.setTheater_num(rs.getString("THEATER_NUM"));
		c.setTheater_type(rs.getString("THEATER_TYPE"));
		c.setPayment(rs.getString("PAYMENT"));
		c.setTotal_price(rs.getInt("TOTAL_PRICE"));
		
		//1) Y && ????????? ???????????? ?????? 	-> ???????????? -> ?????? ??????
		//2) Y && ????????? ???????????? ?????? 	-> ???????????? -> ?????? ??????
		//3) N  				   	-> ???????????? -> ??????
		if(rs.getString("PAY_YN").equals("Y")) {
			if(rs.getDate("SHOW_START").before(date)) { //?????? ?????? ??????
				c.setPay_yn("????????????"); 
				c.setDetail("Y");
				c.setCancel_yn(null); //???????????????
				c.setReview("Y"); //????????????
				System.out.println("????????????");
			}else if(rs.getDate("SHOW_START").after(date)){ //????????????
				c.setPay_yn("????????????");
				c.setDetail("Y");
				c.setCancel_yn("Y"); //????????????
				c.setReview(null);//???????????????	
				System.out.println("????????????");
			}else {	}
		}else {
			c.setPay_yn("????????????");
			c.setDetail("Y");
			c.setCancel_yn(null);
			c.setReview(null);
		}
		return c;
	}
	
	// 1-4. ????????????
	public List<ReservDetailVO> selectSeatNum(int reservation_num) {
		List<ReservDetailVO> resevationlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_SEATNUM_RESERVATION);
			pst.setInt(1, reservation_num); 
			rs = pst.executeQuery();
			while (rs.next()) {
				ReservDetailVO res = makesSeatlist(rs);
				resevationlist.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return resevationlist;
	}

	private ReservDetailVO makesSeatlist(ResultSet rs2) throws SQLException {
		ReservDetailVO c = new ReservDetailVO();
		c.setReservation_num(rs.getInt("RESERVATION_NUM"));
		c.setSeatNum(rs.getString("SEAT_NUM"));
		return c;
	}

	// 2. ????????????
	// 2-1. ?????? - ??????????????? ???????????? ?????? (?????? rs_num -> sc.num -> sc.showstart)
	public int CheckShowReservation(int reservation_num) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CHECK_SHOW_RESERVATION);
			pst.setInt(1, reservation_num);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
			//System.out.println("??????SqlResult" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// 2-2. ?????? - ??????????????? ???????????? ?????? (?????? rs_num -> ?????? sc.num -> sc.showstart)
	public int CheckMovieReservation(int reservation_num) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CHECK_MOVIE_RESERVATION);
			pst.setInt(1, reservation_num);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
			//System.out.println("??????SqlResult" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// r??? rs??????, rs->rd???????????? ???
	// 2-3. ????????????(pay_y->n?????? ??????)
	public int updateReservation(int reservation_num) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE_RESERVATION);
			pst.setInt(1, reservation_num);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// 2-4. rd ????????????SQL_DELETE_SEAT
	public int DeleteSeat(int reservation_num) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE_SEAT);
			pst.setInt(1, reservation_num);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}
}
