package com.kos.showticat.ja0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.VO.CastVO;
import com.kos.showticat.util.DBUtil;

public class CastDAO {
	static final String SQL_SELECT ="SELECT cast_name, cast_url FROM show JOIN CAST using(show_code) "
			+ " JOIN cast_detail using(cast_num) WHERE SHOW_CODE = ?";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//출연배우 조회
	public List<CastVO> selectCast(String show_code) {
		List<CastVO> castList = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT);
			pst.setString(1, show_code);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				castList.add(makeCast(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return castList;
	}

	private CastVO makeCast(ResultSet rs) throws SQLException {
		CastVO cast = new CastVO(rs.getString(1), rs.getString(2));
		return cast;
	}
}
