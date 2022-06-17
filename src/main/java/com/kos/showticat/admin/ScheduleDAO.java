package com.kos.showticat.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.admin.vo.PlaceVO;
import com.kos.showticat.admin.vo.ScheduleShowVO;
import com.kos.showticat.admin.vo.ScheduleVO;
import com.kos.showticat.admin.vo.ShowVO;
import com.kos.showticat.admin.vo.TheaterVO;
import com.kos.showticat.util.DBUtil;

public class ScheduleDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	//SQL
	static final String SQL_SELECT_ALL =
			" SELECT sc.SCHEDULE_NUM , s.SHOW_NAME , p.PLACE_NAME ,sc.THEATER_NUM , sc.SHOW_START , sc.SHOW_START ,t.LAST_SEAT "
			+ " FROM SCHEDULE sc JOIN SHOW s ON (sc.SHOW_CODE = s.SHOW_CODE ) "
			+ "				JOIN THEATER t ON (sc.THEATER_NUM = t.THEATER_NUM ) "
			+ "				JOIN PLACE p ON (sc.PLACE_NUM = p.PLACE_NUM )"
			+ "	order by sc.SCHEDULE_NUM ";
	static final String SQL_SELECT_SHOW_INSERT ="SELECT SHOW_CODE , SHOW_NAME, OPENING_DATE  FROM SHOW";
	static final String SQL_SELECT_PLACE_INSERT ="SELECT PLACE_NUM , PLACE_NAME FROM PLACE";
	static final String SQL_SELECT_THEATER_INSERT ="SELECT THEATER_NUM, PLACE_NUM FROM THEATER WHERE PLACE_NUM = ?";	
	static final String SQL_SELECT_OPENINGDATE_INSERT ="SELECT SHOW_CODE , SHOW_NAME, OPENING_DATE FROM SHOW WHERE SHOW_CODE = ?";	
	static final String SQL_INSERT_SCHEDULE ="INSERT INTO schedule values(seq_schedule_no.nextval,?,?,?,?)";
	static final String SQL_SELECT_RESERVATION_DELETE_SCHEDULE =""
			+ "SELECT count(r.RESERVATION_NUM) FROM RESERVATION r "
			+ " WHERE r.SCHEDULE_NUM  = ? ";	
	static final String SQL_DELETE_SCHEDULE ="DELETE FROM schedule WHERE SCHEDULE_NUM =? ";
	
	
	// 1. 모든 스케줄 조회
	public List<ScheduleShowVO> selectAllSchedule() {
		List<ScheduleShowVO> schedulelist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pst.executeQuery();
			while(rs.next()) {
				schedulelist.add(makesclist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return schedulelist;
	}
	private ScheduleShowVO makesclist(ResultSet rs) throws SQLException {
		ScheduleShowVO sc = new ScheduleShowVO();
		sc.setSchedule_num(rs.getInt("SCHEDULE_NUM"));
		sc.setShow_name(rs.getString("SHOW_NAME"));
		sc.setPlace_name(rs.getString("PLACE_NAME"));
		sc.setTheater_num(rs.getString("THEATER_NUM"));
		sc.setShow_start_date(rs.getDate("SHOW_START"));
		sc.setShow_start_time(rs.getTime("SHOW_START"));
		sc.setLast_seat(rs.getInt("LAST_SEAT"));
		return sc;
	}
	
	// 2. 스케줄 추가
	// 2-1. 스케줄 추가 form보여주기
	// 2-1-1 show 제목 + show 번호
	public List<ShowVO> selectShowInsertSchedule(){
		List<ShowVO> showlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_SHOW_INSERT);
			rs = pst.executeQuery();
			while(rs.next()) {
				showlist.add(makeshowlist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return showlist;
	}
	private ShowVO makeshowlist(ResultSet rs) throws SQLException {
		ShowVO sh = new ShowVO();
		sh.setShow_code(rs.getString("SHOW_CODE"));
		sh.setShow_name(rs.getString("SHOW_NAME"));
		sh.setOpening_date(rs.getDate("OPENING_DATE"));
		return sh;
	}
	
	// 2-1-2 극장이름 + 극장번호
	public List<PlaceVO> selectPlaceInsertSchedule(){
		List<PlaceVO> placelist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_PLACE_INSERT);
			rs = pst.executeQuery();
			while(rs.next()) {
				placelist.add(makeplacelist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return placelist;
	}
	private PlaceVO makeplacelist(ResultSet rs) throws SQLException {
		PlaceVO pl = new PlaceVO();
		pl.setPlace_num(rs.getInt("PLACE_NUM"));
		pl.setPlace_name(rs.getString("PLACE_NAME"));
		
		return pl;
	}
	
	// 2-1-3 상영관번호
	public List<TheaterVO> selectTheaterInsertSchedule(int place_num){
		List<TheaterVO> theaterlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_THEATER_INSERT);
			pst.setInt(1, place_num);  
			rs = pst.executeQuery();
			while(rs.next()) {
				theaterlist.add(maketheaterlist(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return theaterlist;
	}
	private TheaterVO maketheaterlist(ResultSet rs) throws SQLException {
		TheaterVO theater = new TheaterVO();
		theater.setPlace_num(rs.getInt("PLACE_NUM"));
		theater.setTheater_num(rs.getString("THEATER_NUM"));
		return theater;
	}

	// 2-1-4 개봉날짜
	public ShowVO selectOpeningdateInsertSchedule(String show_code) {
		ShowVO show = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_OPENINGDATE_INSERT);
			pst.setString(1, show_code); 
			rs = pst.executeQuery();
			while(rs.next()) {
				show = makeshowlist(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return show;
	}
	
	// 2-2. 스케줄 추가
	public int insertSchedule(ScheduleVO sc) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_INSERT_SCHEDULE);
			pst.setString(1, sc.getShow_code());
			pst.setString(2, sc.getTheater_num());
			pst.setInt(3, sc.getPlace_num());
			pst.setDate(4, sc.getShow_start());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// 3. 스케줄 삭제
	// 3-1. 해당 스케줄의 판매 횟수 조회 (조건조회)
	public int selectBuySchedule(int schedule_num) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_RESERVATION_DELETE_SCHEDULE);
			pst.setInt(1, schedule_num);  
			rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// 3-2. 스케줄 삭제
	public int deleteSchedule(int schedule_num) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE_SCHEDULE);
			pst.setInt(1, schedule_num);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}
}
