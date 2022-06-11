package com.kos.showticat.ja0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.VO.ShowVO;
import com.kos.showticat.util.DButil;

public class ShowDAO {
	static final String SQL_SELECT ="select * from show";
	static final String SQL_SELECT_CATEGORY ="select * from show where category = ?";
	static final String SQL_SELECT_CODE ="select * from show where show_code=?";
	static final String SQL_SEARCH ="select * from show where show_name like '%'||"+"?"+"||'%'";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//怨듭뿰紐⑸줉 �쟾泥댁“�쉶
	public List<ShowVO> selectAll() {
		List<ShowVO> showList = new ArrayList<>();
		conn = DButil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				showList.add(makeShow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(conn);
		}
	
		return showList;
	}
	
	//�쁺�솕/怨듭뿰 媛곸옄 紐⑸줉
	public List<ShowVO> selectCategory(String category) {
		List<ShowVO> showList = new ArrayList<>();
		conn = DButil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CATEGORY);
			pst.setString(1, category);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				showList.add(makeShow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(conn);
		}
		
		return showList;
	}
	
	//怨듭뿰肄붾뱶濡� 議고쉶
	public ShowVO selectShow(String show_code) {
		ShowVO show = new ShowVO();
		conn = DButil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CODE);
			pst.setString(1, show_code);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				show = makeShow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(conn);
		}
		return show;
	}
	
	//寃��깋紐⑸줉 �쟾泥댁“�쉶
	public List<ShowVO> selectSearch(String word) {
		List<ShowVO> showList = new ArrayList<>();
		conn = DButil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SEARCH);
			pst.setString(1, word);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				showList.add(makeShow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DButil.dbClose(conn);
		}
		
		return showList;
	}

	private ShowVO makeShow(ResultSet rs) throws SQLException {
		ShowVO show = new ShowVO();
		
		show.setCategory(rs.getString("category"));
		show.setDirector(rs.getString("director"));
		show.setOpening_date(rs.getDate("opening_date"));
		show.setPoster(rs.getString("poster"));
		show.setPrice(rs.getInt("price"));
		show.setShow_code(rs.getString("show_code"));
		show.setShow_name(rs.getString("show_name"));
		show.setShow_time(rs.getString("show_time"));
		show.setSummary(rs.getString("summary"));
		show.setTrailer(rs.getString("trailer"));
		
		
		return show;
	}
}
