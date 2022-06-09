package com.kos.showticat.reservation.dao.temp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.reservation.dao.temp.MembersVO;
import com.kos.showticat.reservation.dao.temp.ReservationVO;
import com.kos.showticat.reservation.dao.temp.ScheduleVO;
import com.kos.showticat.util.DButil;

public class ScheduleDAO {
	
	final static String SQL_SCHEDULE_SELECT_SHOW_CODE="SELECT SHOW_CODE FROM SCHEDULE WHERE SCHEDULE_NUM=?";
	final static String SQL_SCHEDULE_UPDATE_SHOW_START = "UPDATE schedule SET show_start=? WHERE  SCHEDULE_NUM =?";
	final static String SQL_SCHEDULE_UPDATE_THEATER_PLACE_NUMBER="UPDATE schedule SET THEATER_NUM=?, PLACE_NUM=? WHERE  SCHEDULE_NUM =?";
	final static String SQL_SCHEDULE_INSERT_SCHEDULE_NUMBER="INSERT INTO schedule values(?, ?, 'A1',1000,sysdate)";
	final static String SQL_SCHEDULE_INSERT="INSERT INTO SCHEDULE VALUES (?, ?, ?, ?, ?)";	
	final static String SQL_SCHEDULE_SELECT_ALL ="select schedule_num, show_code, theater_num, place_num, show_start from schedule";
	final static String SQL_SCHEDULE_POINT_SELECT_ALL ="select*from members";
	final static String SQL_SCHEDULE_POINT_UPDATE="update members set point=? where m_id=? and m_pw=?";
	
	final static String SQL_RESERVATION_SELECT_SCHEDULE_NUMBER_BY_RESERVATION_NUMBER="SELECT SCHEDULE_NUM  FROM RESERVATION WHERE RESERVATION_NUM=?";
	final static String SQL_RESERVATION_INSERT="INSERT INTO RESERVATION values(?, ?, sysdate, ?, 'temp', 0, 'N')";
	final static String SQL_RESERVATION_UPDATE_PAYMENT_TOTALPRICES="UPDATE RESERVATION  SET PAYMENT=?, TOTAL_PRICE=? WHERE RESERVATION_NUM=?";
	final static String SQL_RESERVATION_UPDATE_PAYMENT_YN="UPDATE RESERVATION SET PAY_YN =? WHERE  RESERVATION_NUM =?";
	final static String SQL_RESERVATION_SELECT="SELECT m_id, reservation_date, schedule_num, payment, total_price, pay_yn FROM RESERVATION WHERE RESERVATION_NUM=?";
	
	final static String SQL_RESERVATION_DETAIL_INSERT="INSERT INTO RESERV_DETAIL VALUES (?,?)";
	final static String SQL_RESERVATION_DETAIL_UPDATE="UPDATE RESERV_DETAIL SET SEAT_NUM=? WHERE RESERVATION_NUM=?";
	
	final static String SQL_PLACE_SELECT_ALL = "SELECT place_num, place_name, place_loc, place_phone FROM PLACE";
	
	final static String SQL_THEATER_SELECT_BY_THEATER_NUMBER="SELECT PLACE_NUM FROM THEATER WHERE THEATER_NUM =?";
	final static String SQL_THEATER_SELECT_ALL ="SELECT theater_num, theater_type, LAST_SEAT, PLACE_NUM FROM THEATER";
	final static String SQL_THEATER_SELECT_BY_PLACE_NUMBER = "SELECT theater_num, theater_type, LAST_SEAT, PLACE_NUM FROM THEATER where PLACE_NUM=?";
	
	final static String SQL_SHOW_SELECT_PRICE_BY_SHOW_CODE="SELECT PRICE FROM SHOW WHERE SHOW_CODE=?";
	
	
	public int selectReservationByReservationNum(int reservationNum) {
		int scheduleNum = 0;
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_SELECT_SCHEDULE_NUMBER_BY_RESERVATION_NUMBER);
			ppst.setInt(1, reservationNum);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				scheduleNum = rs.getInt("schedule_num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}			
		return scheduleNum;
	}
	
	public int selectShowByShowCode(String showCode) {
		int price = 0;
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_SHOW_SELECT_PRICE_BY_SHOW_CODE);
			ppst.setString(1, showCode);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				price = rs.getInt("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}	
		return price;
	}
	
	public String selectScheduleByScheduleNum(int scheduleNumber) {
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		String showCode=null;
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_SELECT_SHOW_CODE);
			ppst.setInt(1, scheduleNumber);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				showCode = rs.getString("show_code");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}	
		
		return showCode;
	}
	
	public void updateScheduleShowstart(Date showStart, int scheduleNum) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_UPDATE_SHOW_START);
			ppst.setDate(1, showStart);
			ppst.setInt(2, scheduleNum);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateScheduleShowstart=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
	}
	
	public void updateScheduleTheaterPlacenum(String theaterNum, int placeNum, int schedulNum) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_UPDATE_THEATER_PLACE_NUMBER);
			ppst.setString(1, theaterNum);
			ppst.setInt(2, placeNum);
			ppst.setInt(3, schedulNum);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateScheduleTheaterPlacenum=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
	}
	
	public int selectPlaceByTheaterNum(String theaterNum) {
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		int placeNum = 0;
		
		try {
			ppst = con.prepareStatement(SQL_THEATER_SELECT_BY_THEATER_NUMBER);
			ppst.setString(1, theaterNum);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				placeNum = rs.getInt("PLACE_NUM");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}	
		return placeNum;
	}
	
	public void insertScheduleInforNum(int scheduleNum, String showCode) {
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_INSERT_SCHEDULE_NUMBER);
			ppst.setInt(1, scheduleNum);
			ppst.setString(2, showCode);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.insertScheduleInforNum=>insert data");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}		
	}
	
	public List<TheaterVO> selectTheaterByPlaceNum(int placeNum){
		
		List<TheaterVO> tList = new ArrayList<>();
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs=null;
		
		try {
			ppst = con.prepareStatement(SQL_THEATER_SELECT_BY_PLACE_NUMBER);
			ppst.setInt(1, placeNum);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				TheaterVO temp = new TheaterVO();
				temp.setTheater_num(rs.getString("theater_num"));
				temp.setTheater_type(rs.getString("theater_type"));
				temp.setLast_seat(rs.getInt("LAST_SEAT"));
				temp.setPlace_num(rs.getInt("PLACE_NUM"));
				tList.add(temp);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
		return tList;
	}
	
	public List<TheaterVO> selectAllTheater(){
		List<TheaterVO> tList = new ArrayList<>();
		Connection con = DButil.getConnection();
		Statement st=null;
		ResultSet rs=null;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(SQL_THEATER_SELECT_ALL);
			
			while(rs.next()) {
				TheaterVO temp = new TheaterVO();
				temp.setTheater_num(rs.getString("theater_num"));
				temp.setTheater_type(rs.getString("theater_type"));
				temp.setLast_seat(rs.getInt("LAST_SEAT"));
				temp.setPlace_num(rs.getInt("PLACE_NUM"));
				tList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}		
		return tList;
	}
	
	public List<PlaceVO> selectALLPlace() {
		
		List<PlaceVO> pList = new ArrayList<>();
		Connection con = DButil.getConnection();
		Statement st=null;
		ResultSet rs=null;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(SQL_PLACE_SELECT_ALL);
			
			while(rs.next()) {
				PlaceVO temp = new PlaceVO();
				temp.setPlace_num(rs.getInt("place_num"));
				temp.setPlace_name(rs.getString("place_name"));
				temp.setPlace_loc(rs.getString("place_loc"));
				temp.setPlace_phone(rs.getString("place_phone"));
				pList.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
		return pList;
	}
	
	public void insertScheduleInfor(int scheduleNum, String showCode, String theaterNum, int placeNum, String showStart) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		//string -> timestamp -> date
		Timestamp sStart = Timestamp.valueOf(showStart);
		Date sDate = new Date(sStart.getTime());
		
		try {	
			ppst = con.prepareStatement(SQL_SCHEDULE_INSERT);
			ppst.setInt(1, scheduleNum);
			ppst.setString(2, showCode);
			ppst.setString(3, theaterNum);
			ppst.setInt(4, placeNum);
			ppst.setDate(5, sDate);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.insertScheduleInfor=>insert data");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
	}
	
	
	public ReservationVO reservationSelectByNumber(int reservatioNum) {
		
		ReservationVO rvo = new ReservationVO();
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_SELECT);
			ppst.setInt(1, reservatioNum);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				rvo.setReservationNum(String.valueOf(reservatioNum));
				rvo.setmID(rs.getString("m_id"));
				rvo.setReservationDate(rs.getString("reservation_date"));
				rvo.setScheduleNum(rs.getString("schedule_num"));
				rvo.setPayment(rs.getString("payment"));
				rvo.setTotalPrice(rs.getString("total_price"));
				rvo.setPayYN(rs.getString("pay_yn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}

		return rvo;
	}
	
	
	public void updateReservationPaymentYN(String paymentYN, int reservatioNum) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_UPDATE_PAYMENT_YN);
			ppst.setString(1, paymentYN);
			ppst.setInt(2, reservatioNum);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateReservationPaymentYN=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
	}
	
	
	public void updateReservationDetailInfor(String seatNum, int reservationNum) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_DETAIL_UPDATE);
			ppst.setString(1, seatNum);
			ppst.setInt(2, reservationNum);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateReservationDetailInfor=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
	}
	
	
	public void insertReservationDetailInfor(int reserNum, String seatNumb) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_DETAIL_INSERT);
			ppst.setInt(1, reserNum);
			ppst.setString(2, seatNumb);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.insertReservationDetailInfor=>insert data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}		
	}
	
	
	public void updateReservationInfor(String payment, int totalPrice, int reservationNum) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_UPDATE_PAYMENT_TOTALPRICES);
			ppst.setString(1, payment);
			ppst.setInt(2, totalPrice);
			ppst.setInt(3, reservationNum);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateReservationInfor=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
	}
	
	
	public void insertReservationInfor(int reserNum, String mID, int schedNum) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;

		try {
			ppst = con.prepareStatement(SQL_RESERVATION_INSERT);
			ppst.setInt(1, reserNum);
			ppst.setString(2, mID);
			ppst.setInt(3, schedNum);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.insertReservationInfor=>insert data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
		}
	}
	
	
	public void updatePointMembers(String id, String pw, int point) {
		
		Connection con = DButil.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst =  con.prepareStatement(SQL_SCHEDULE_POINT_UPDATE);
			ppst.setInt(1, point);
			ppst.setString(2, id);
			ppst.setString(3, pw);
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updatePointMembers=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			DButil.dbClose(con);
		}
	}

	
	public List<MembersVO> selectALLMembers(){
		
		List<MembersVO> mvoList = new ArrayList<>();
		Connection con = DButil.getConnection();
		Statement st=null;
		ResultSet rs=null;
		
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(SQL_SCHEDULE_POINT_SELECT_ALL);
			
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
		}finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(con);
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
