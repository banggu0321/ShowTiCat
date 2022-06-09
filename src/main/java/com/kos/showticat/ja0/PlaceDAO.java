package com.kos.showticat.ja0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.util.DBUtil;

public class PlaceDAO {
	static final String SQL_SELECT_ALL ="select * from place order by 2";
	static final String SQL_SELECT ="select * from place where place_num = ?";

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//극장 전체조회
	public List<PlaceVO> selectAll() {
		List<PlaceVO> placeList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL);

			rs = pst.executeQuery();
			
			while(rs.next()) {
				placeList.add(makePlace(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return placeList;
	}
	
	//극장 조회
	public PlaceVO selectByNum(int place_num) {
		PlaceVO place = new PlaceVO();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT);
			pst.setInt(1, place_num);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				place = makePlace(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return place;
	}

	private PlaceVO makePlace(ResultSet rs) throws SQLException {
		PlaceVO place = new PlaceVO();
		
		place.setPlace_loc(rs.getString("place_loc"));
		place.setPlace_name(rs.getString("place_name"));
		place.setPlace_num(rs.getInt("place_num"));
		place.setPlace_phone(rs.getString("place_phone"));
		
		return place;
	}
}
