package com.kos.showticat.cansu.dao;

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

import com.kos.showticat.cansu.dao.MembersVO;
import com.kos.showticat.cansu.dao.ReservationVO;
import com.kos.showticat.cansu.dao.ScheduleVO;
import com.kos.showticat.util.DBUtil2;

public class ScheduleDAO {
	
	final static String SQL_SCHEDULE_SELECT_BY_JOIN_PLACE = "SELECT s.THEATER_NUM, s.PLACE_NUM, s.SHOW_START, p.PLACE_NAME, s.SCHEDULE_NUM  FROM SCHEDULE s INNER JOIN PLACE p ON s.PLACE_NUM = p.PLACE_NUM WHERE SHOW_CODE =? AND  SHOW_START>SYSDATE";
	final static String SQL_SCHEDULE_SELECT_ALL ="select schedule_num, show_code, theater_num, place_num, show_start from schedule";
	final static String SQL_SCHEDULE_SELECT_SCHEDULE_BY_SHOW_CODE="SELECT THEATER_NUM, PLACE_NUM , SHOW_START FROM SCHEDULE WHERE SHOW_CODE=?";
	final static String SQL_SCHEDULE_SELECT_SCHEDULE_NUMBER_BY_SHOW_CODE="SELECT SCHEDULE_NUM  FROM SCHEDULE WHERE show_code=? AND  THEATER_NUM =? AND PLACE_NUM=?";
	final static String SQL_SCHEDULE_SELECT_BY_SCHEDULE_NUM="SELECT SHOW_CODE, THEATER_NUM, PLACE_NUM , SHOW_START FROM SCHEDULE WHERE SCHEDULE_NUM=?";
	final static String SQL_SCHEDULE_DELETE_BY_SCHEDULE_NUMBER = "DELETE FROM SCHEDULE WHERE SCHEDULE_NUM =?";
	final static String SQL_SCHEDULE_UPDATE_OTHER_BY_SHCEDULE_NUMBER="UPDATE SCHEDULE SET THEATER_NUM=?, PLACE_NUM=?, SHOW_START=? WHERE SCHEDULE_NUM=?";
	final static String SQL_SCHEDULE_SELECT_SHOW_CODE="SELECT SHOW_CODE FROM SCHEDULE WHERE SCHEDULE_NUM=?";
	final static String SQL_SCHEDULE_UPDATE_SHOW_START = "UPDATE schedule SET show_start=? WHERE  SCHEDULE_NUM =?";
	final static String SQL_SCHEDULE_UPDATE_THEATER_PLACE_NUMBER="UPDATE schedule SET THEATER_NUM=?, PLACE_NUM=? WHERE  SCHEDULE_NUM =?";
	final static String SQL_SCHEDULE_INSERT_SCHEDULE_NUMBER="INSERT INTO schedule values(?, ?, 'A1',1000,sysdate)";
	final static String SQL_SCHEDULE_INSERT="INSERT INTO SCHEDULE VALUES (?, ?, ?, ?, ?)";	
	final static String SQL_SCHEDULE_POINT_SELECT_ALL ="select*from members";
	final static String SQL_SCHEDULE_POINT_UPDATE="update members set point=? where m_id=?";

	final static String SQL_RESERVATION_SELECT_TOTAL_PRICE_BY_RESERVATION_NUMBER="SELECT TOTAL_PRICE  FROM RESERVATION WHERE RESERVATION_NUM =?";
	final static String SQL_RESERVATION_SELECT_mID_BY_RESERVATION_NUMBER="SELECT M_ID  FROM RESERVATION WHERE RESERVATION_NUM =?";
	final static String SQL_RESERVATION_SELECT_RESERVATION_NUMBER_BY_JOIN_SCHEDULE ="SELECT r.RESERVATION_NUM, r.M_ID, r.SCHEDULE_NUM, s.SCHEDULE_NUM, s.SHOW_CODE  FROM RESERVATION r INNER JOIN SCHEDULE s ON r.SCHEDULE_NUM = s.SCHEDULE_NUM WHERE s.SHOW_CODE=? AND s.SCHEDULE_NUM=?";
	final static String SQL_RESERVATION_SELECT_ALL_BY_ID="SELECT RESERVATION_NUM, M_ID , RESERVATION_DATE, SCHEDULE_NUM, PAYMENT, TOTAL_PRICE, PAY_YN FROM RESERVATION WHERE M_ID =?";	
	final static String SQL_RESERVATION_SELECT_ID_BY_RESERVATION_NUMBER="SELECT M_ID FROM RESERVATION WHERE RESERVATION_NUM =?";
	final static String SQL_RESERVATION_SELECT_SCHEDULE_NUMBER_BY_RESERVATION_NUMBER="SELECT SCHEDULE_NUM  FROM RESERVATION WHERE RESERVATION_NUM=?";
	final static String SQL_RESERVATION_SELECT="SELECT m_id, reservation_date, schedule_num, payment, total_price, pay_yn FROM RESERVATION WHERE RESERVATION_NUM=?";
	final static String SQL_RESERVATION_UPDATE_PAYMENT_BY_RESER_NUM = "UPDATE reservation SET PAYMENT=? WHERE RESERVATION_NUM =?";
	final static String SQL_RESERVATION_UPDATE_TOTALPRICE_BY_RESER_NUM = "UPDATE reservation SET TOTAL_PRICE=? WHERE RESERVATION_NUM =?";
	final static String SQL_RESERVATION_UPDATE_PAYMENT_TOTALPRICES="UPDATE RESERVATION  SET PAYMENT=?, TOTAL_PRICE=? WHERE RESERVATION_NUM=?";
	final static String SQL_RESERVATION_UPDATE_PAYMENT_YN="UPDATE RESERVATION SET PAY_YN =? WHERE  RESERVATION_NUM =?";
	final static String SQL_RESERVATION_INSERT="INSERT INTO RESERVATION values(?, ?, current_timestamp, ?, 'temp', 0, 'N')";
	final static String SQL_RESERVATION_DETAIL_INSERT="INSERT INTO RESERV_DETAIL VALUES (?,?)";
	final static String SQL_RESERVATION_DETAIL_UPDATE="UPDATE RESERV_DETAIL SET SEAT_NUM=? WHERE RESERVATION_NUM=?";

	final static String SQL_THEATER_SELECT_BY_THEATER_NUMBER="SELECT PLACE_NUM FROM THEATER WHERE THEATER_NUM =?";
	final static String SQL_THEATER_SELECT_ALL ="SELECT theater_num, theater_type, LAST_SEAT, PLACE_NUM FROM THEATER";
	final static String SQL_THEATER_SELECT_BY_PLACE_NUMBER = "SELECT theater_num, theater_type, LAST_SEAT, PLACE_NUM FROM THEATER where PLACE_NUM=?";

	final static String SQL_PLACE_SELECT_ALL = "SELECT place_num, place_name, place_loc, place_phone FROM PLACE";
	
	final static String SQL_SHOW_SELECT_BY_SHOW_CODE="SELECT SHOW_NAME, DIRECTOR, SHOW_TIME, POSTER FROM SHOW WHERE SHOW_CODE=?";
	final static String SQL_SHOW_SELECT_PRICE_BY_SHOW_CODE="SELECT PRICE FROM SHOW WHERE SHOW_CODE=?";
	final static String SQL_CHART_SELECT_ALL_SHOW_CODE="SELECT show_code FROM CHART";

	final static String SQL_MEMBER_SELECT_GENDER_BY_ID ="SELECT GENDER FROM MEMBERS WHERE M_ID=?";
	final static String SQL_MEMBER_SELECT_POINT_BY_ID ="SELECT POINT FROM MEMBERS WHERE M_ID=?";

	final static String SQL_CHART_SELECT_RATE_WM_BY_SHOW_CODE="SELECT RATE_M, RATE_W FROM CHART WHERE SHOW_CODE=?";
	final static String SQL_CHART_UPDATE_GENDER_M_BY_CHECK="UPDATE CHART SET RATE_M=? WHERE SHOW_CODE=?";
	final static String SQL_CHART_UPDATE_GENDER_W_BY_CHECK="UPDATE CHART SET RATE_W=? WHERE SHOW_CODE=?";
	
	final static String SQL_RESERVATION_DETAIL_BY_RESERVATION_NUM="SELECT SEAT_NUM FROM RESERV_DETAIL WHERE RESERVATION_NUM =?";
	
	
	
	public int selectReservationTpriceByNum(int reservationNum) {
		int totalPrice = 0;
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_SELECT_TOTAL_PRICE_BY_RESERVATION_NUMBER);
			ppst.setInt(1, reservationNum);
			rs = ppst.executeQuery();

			while(rs.next()) {
				totalPrice = rs.getInt("total_price");
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
			DBUtil2.dbClose(con);
		}				
		return totalPrice;
	}
	
	public String selectReservationIDbyNum(int reservationNum) {
		String mID = null;
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_SELECT_mID_BY_RESERVATION_NUMBER);
			ppst.setInt(1, reservationNum);
			rs = ppst.executeQuery();

			while(rs.next()) {
				mID = rs.getString("m_id");
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
			DBUtil2.dbClose(con);
		}				
		return mID;
	}
	
	public List<ScheduleJoinPlaceVO> selectScheduleInfoByJoinPlace(String showCode){
		
		List<ScheduleJoinPlaceVO> spList = new ArrayList<>();
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;

		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_SELECT_BY_JOIN_PLACE);
			ppst.setString(1, showCode);
			rs = ppst.executeQuery();

			while(rs.next()) {
				ScheduleJoinPlaceVO spVO = new ScheduleJoinPlaceVO();
				spVO.setTheaterNum(rs.getString("theater_num"));
				spVO.setPlaceNum(rs.getInt("place_num"));
				spVO.setShowStart(rs.getString("show_start"));
				spVO.setPlaceName(rs.getString("place_name"));
				spVO.setScheduleNum(rs.getInt("schedule_num"));  //SCHEDULE_NUM
				spList.add(spVO);
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
			DBUtil2.dbClose(con);
		}		
		return spList;
	}
	
	public List<String> selectReservationDetailByNumber(int reservationNum) {
		List<String> seatNum = new ArrayList<>();
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_DETAIL_BY_RESERVATION_NUM);
			ppst.setInt(1, reservationNum);
			rs = ppst.executeQuery();

			while(rs.next()) {
				String temp = rs.getString("seat_num");
//				System.out.println(temp);
				
				seatNum.add(temp); 
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
			DBUtil2.dbClose(con);
		}			
		return seatNum;
	}
	
	public List<Integer> selectReservationByJoinSchedule(int scheduleNum, String showCode) {
		//SELECT r.RESERVATION_NUM, r.M_ID, r.SCHEDULE_NUM, s.SCHEDULE_NUM, s.SHOW_CODE  FROM RESERVATION r INNER JOIN SCHEDULE s ON r.SCHEDULE_NUM = s.SCHEDULE_NUM WHERE s.SHOW_CODE=? AND s.SCHEDULE_NUM=?
		List<Integer> iList = new ArrayList<>();
		
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_SELECT_RESERVATION_NUMBER_BY_JOIN_SCHEDULE);
			ppst.setString(1, showCode);
			ppst.setInt(2, scheduleNum);
			rs = ppst.executeQuery();

			while(rs.next()) {
				int reservationNum = rs.getInt("reservation_num");
				iList.add(reservationNum);
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
			DBUtil2.dbClose(con);
		}				
		return iList;
	}
	
	public List<ReservationVO> selectReservationByID(String mID) {
		//SELECT RESERVATION_NUM, M_ID , RESERVATION_DATE, SCHEDULE_NUM, PAYMENT, TOTAL_PRICE, PAY_YN FROM RESERVATION WHERE M_ID ='bang'
		List<ReservationVO> rvoList = new ArrayList<>();
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_SELECT_ALL_BY_ID);
			ppst.setString(1, mID);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				ReservationVO temp = new ReservationVO();
				temp.setmID(mID);
				temp.setReservationNum(rs.getInt("reservation_num"));
				temp.setReservationDate(rs.getString("reservation_date"));
				temp.setPayment(rs.getString("payment"));
				temp.setTotalPrice(rs.getString("total_price"));
				temp.setPayYN(rs.getString("pay_yn"));
				rvoList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil2.dbClose(con);
		}			
		return rvoList;
	}
	
	public int selectScheduleBythreeAttri(String showCode, String theaterNum, int placeNum) {
		int result=0;
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		//SELECT SCHEDULE_NUM  FROM SCHEDULE WHERE show_code=? AND  THEATER_NUM =? AND PLACE_NUM=?
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_SELECT_SCHEDULE_NUMBER_BY_SHOW_CODE);
			ppst.setString(1, showCode);
			ppst.setString(2, theaterNum);
			ppst.setInt(3, placeNum);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				result=rs.getInt("schedule_num");
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
			DBUtil2.dbClose(con);
		}		
		return result;
	}
	
	
	public ScheduleVO selectScheduleByScheduleNumBeta(int scheduleNum) {
		
		ScheduleVO svo = new ScheduleVO();
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_SELECT_BY_SCHEDULE_NUM);
			ppst.setInt(1, scheduleNum);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				svo.setTheaterNum(rs.getString("theater_num"));
				svo.setPlaceNum(rs.getInt("place_num"));
				svo.setShowStart(rs.getString("show_start"));
				svo.setShowCode(rs.getString("show_code"));
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
			DBUtil2.dbClose(con);
		}			
		return svo;
	}
	
	public void deleteScheduleByScheduleNum(int scheduleNum) {
		//DELETE FROM SCHEDULE WHERE SCHEDULE_NUM =?
		
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_DELETE_BY_SCHEDULE_NUMBER);
			ppst.setInt(1, scheduleNum);
			
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.deleteScheduleByScheduleNum=>delete data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil2.dbClose(con);
		}		
	}
	
	public ShowVO selectShowByShowcode(String showCode) {
		
		ShowVO svo = new ShowVO();
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_SHOW_SELECT_BY_SHOW_CODE);
			ppst.setString(1, showCode);
			rs = ppst.executeQuery();
			
			while(rs.next()) {
				svo.setShowName(rs.getString("show_name"));				
				svo.setDirector(rs.getString("director"));
				svo.setShowTime(rs.getString("show_time"));
				svo.setPoster(rs.getString("poster"));
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
			DBUtil2.dbClose(con);
		}		
		return svo;
	}
	
	public void updateReservationPaymentByResNum(String payment, int reservationNum) {
		
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_UPDATE_PAYMENT_BY_RESER_NUM);
			ppst.setString(1, payment);
			ppst.setInt(2, reservationNum);
			
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateReservationPaymentByResNum=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil2.dbClose(con);
		}		
		
	}
	
	public void updateReservationByReserveNum(int totalPrice, int reservationNum) {
		
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		
		try {
			ppst = con.prepareStatement(SQL_RESERVATION_UPDATE_TOTALPRICE_BY_RESER_NUM);
			ppst.setInt(1, totalPrice);
			ppst.setInt(2, reservationNum);
			
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateReservationByReserveNum=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil2.dbClose(con);
		}		
	}
	
	public void updateScheduleByScheduleNum(String theaterNum, int placeNum, String showStart, int scheduleNum) {
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		
		//string -> timestamp -> date
		Timestamp sStart = Timestamp.valueOf(showStart);
		Date sDate = new Date(sStart.getTime());
		
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_UPDATE_OTHER_BY_SHCEDULE_NUMBER);
			ppst.setString(1, theaterNum);
			ppst.setInt(2, placeNum);
			ppst.setDate(3, sDate);
			ppst.setInt(4, scheduleNum);
			
			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateScheduleByScheduleNum=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil2.dbClose(con);
		}		
	}
	
	public List<ScheduleVO> selectScheduleByShowcode(String showCode){
		
		List<ScheduleVO> sList = new ArrayList<>();
		
		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;
		
		try {
			ppst = con.prepareStatement(SQL_SCHEDULE_SELECT_SCHEDULE_BY_SHOW_CODE);
			ppst.setString(1, showCode);
			rs = ppst.executeQuery();

			while(rs.next()) {
				ScheduleVO svo = new ScheduleVO();
				svo.setTheaterNum(rs.getString("theater_num"));
				svo.setPlaceNum(rs.getInt("place_num"));
				svo.setShowStart(rs.getString("show_start"));
//				System.out.println(svo);
				sList.add(svo);
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
			DBUtil2.dbClose(con);
		}			
		return sList;
	}

	public List<ChartVO> selectChartShowCode(){
		List<ChartVO> cList = new ArrayList<>();

		Connection con = DBUtil2.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(SQL_CHART_SELECT_ALL_SHOW_CODE);

			while(rs.next()) {
				ChartVO cvo = new ChartVO();
				cvo.setShowCode(rs.getString("show_code"));
				cList.add(cvo);
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
			DBUtil2.dbClose(con);
		}	
		return cList;
	}

	public int selectMembersPointByID(String mID) {

		int point = 0;

		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;

		try {
			ppst = con.prepareStatement(SQL_MEMBER_SELECT_POINT_BY_ID);
			ppst.setString(1, mID);
			rs = ppst.executeQuery();

			while(rs.next()) {
				point = rs.getInt("point");
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
			DBUtil2.dbClose(con);
		}		
		return point;
	}

	public String selectReservationUserIDByReservationNum(int reservationNum) {
		String mID = null;

		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;

		try {
			ppst = con.prepareStatement(SQL_RESERVATION_SELECT_ID_BY_RESERVATION_NUMBER);
			ppst.setInt(1, reservationNum);
			rs = ppst.executeQuery();

			while(rs.next()) {
				mID = rs.getString("m_id");
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
			DBUtil2.dbClose(con);
		}				
		return mID;
	}

	public void updateChartGenderWByCheck(int rate, String showCode) {

		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;

		try {
			ppst = con.prepareStatement(SQL_CHART_UPDATE_GENDER_W_BY_CHECK);
			ppst.setInt(1, rate);
			ppst.setString(2, showCode);

			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateChartGenderWByCheck=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil2.dbClose(con);
		}
	}

	public void updateChartGenderMByCheck(int rate, String showCode) {

		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;

		try {
			ppst = con.prepareStatement(SQL_CHART_UPDATE_GENDER_M_BY_CHECK);
			ppst.setInt(1, rate);
			ppst.setString(2, showCode);

			int result = ppst.executeUpdate();
			if(result == 1) {
				System.out.println("ScheduleDAO.updateChartGenderMByCheck=>update data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ppst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil2.dbClose(con);
		}
	}

	public List<String> selectChartByShowCode(String showCode) {

		List<String> rateWM = new ArrayList<>();

		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;

		try {
			ppst = con.prepareStatement(SQL_CHART_SELECT_RATE_WM_BY_SHOW_CODE);
			ppst.setString(1, showCode);
			rs = ppst.executeQuery();

			while(rs.next()) {
				rateWM.add(rs.getString("rate_w"));
				rateWM.add(rs.getString("rate_m"));
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
			DBUtil2.dbClose(con);
		}			
		return rateWM;
	}

	public String selectMemberByID(String mID) {

		String gender = null;

		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;

		try {
			ppst = con.prepareStatement(SQL_MEMBER_SELECT_GENDER_BY_ID);
			ppst.setString(1, mID);
			rs = ppst.executeQuery();

			while(rs.next()) {
				gender = rs.getString("gender");
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
			DBUtil2.dbClose(con);
		}			
		return gender;		
	}


	public int selectReservationByReservationNum(int reservationNum) {
		int scheduleNum = 0;

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}			
		return scheduleNum;
	}

	public int selectShowByShowCode(String showCode) {
		int price = 0;

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}	
		return price;
	}

	public String selectScheduleByScheduleNum(int scheduleNumber) {
		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}	

		return showCode;
	}

	public void updateScheduleShowstart(Date showStart, int scheduleNum) {

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
	}

	public void updateScheduleTheaterPlacenum(String theaterNum, int placeNum, int schedulNum) {

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
	}

	public int selectPlaceByTheaterNum(String theaterNum) {
		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}	
		return placeNum;
	}

	public void insertScheduleInforNum(int scheduleNum, String showCode) {
		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}		
	}

	public List<TheaterVO> selectTheaterByPlaceNum(int placeNum){

		List<TheaterVO> tList = new ArrayList<>();
		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
		return tList;
	}

	public List<TheaterVO> selectAllTheater(){
		List<TheaterVO> tList = new ArrayList<>();
		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}		
		return tList;
	}

	public List<PlaceVO> selectALLPlace() {

		List<PlaceVO> pList = new ArrayList<>();
		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
		return pList;
	}

	public void insertScheduleInfor(int scheduleNum, String showCode, String theaterNum, int placeNum, String showStart) {

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
	}


	public ReservationVO reservationSelectByNumber(int reservatioNum) {

		ReservationVO rvo = new ReservationVO();

		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;
		ResultSet rs = null;

		try {
			ppst = con.prepareStatement(SQL_RESERVATION_SELECT);
			ppst.setInt(1, reservatioNum);
			rs = ppst.executeQuery();

			while(rs.next()) {
				rvo.setReservationNum(reservatioNum);
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
			DBUtil2.dbClose(con);
		}

		return rvo;
	}


	public void updateReservationPaymentYN(String paymentYN, int reservatioNum) {

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
	}


	public void updateReservationDetailInfor(String seatNum, int reservationNum) {

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
	}


	public void insertReservationDetailInfor(int reserNum, String seatNumb) {

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}		
	}


	public void updateReservationInfor(String payment, int totalPrice, int reservationNum) {

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
	}


	public void insertReservationInfor(int reserNum, String mID, int schedNum) {

		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
	}


	public void updatePointMembers(String id, int point) {

		Connection con = DBUtil2.getConnection();
		PreparedStatement ppst=null;

		try {
			ppst =  con.prepareStatement(SQL_SCHEDULE_POINT_UPDATE);
			ppst.setInt(1, point);
			ppst.setString(2, id);
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

			DBUtil2.dbClose(con);
		}
	}


	public List<MembersVO> selectALLMembers(){

		List<MembersVO> mvoList = new ArrayList<>();
		Connection con = DBUtil2.getConnection();
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
			DBUtil2.dbClose(con);
		}
		return mvoList;	
	}


	public List<ScheduleVO> selectALL() {
		List<ScheduleVO> scdList = new ArrayList<>();

		Connection con = DBUtil2.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(SQL_SCHEDULE_SELECT_ALL);

			while(rs.next()) {
				ScheduleVO scvo = new ScheduleVO();
				scvo.setScheduleNum(String.valueOf(rs.getInt("schedule_num")));
				scvo.setShowCode(rs.getString("show_code"));
				scvo.setTheaterNum(rs.getString("theater_num"));
				scvo.setPlaceNum(rs.getInt("place_num"));
				scvo.setShowStart(rs.getString("show_start"));
				scdList.add(scvo);
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
			DBUtil2.dbClose(con);
		}	
		return scdList;
	}

}
