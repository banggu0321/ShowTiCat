package com.kos.showticat.jayoung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kos.showticat.util.DBUtil;

public class ChartDAO {
	static final String SQL_SELECT ="select * from chart where show_code = ?";
	
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;
	
	//차트 정보 가져오기
	public ChartVO selectShow(String show_code) {
		ChartVO chart = new ChartVO();
		
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT);
			pst.setString(1, show_code);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				chart = makeChart(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		
		return chart;
	}

	private ChartVO makeChart(ResultSet rs) throws SQLException {
		ChartVO chart = new ChartVO();
		
		chart.setRate_10(rs.getInt("rate_10"));
		chart.setRate_20(rs.getInt("rate_20"));
		chart.setRate_30(rs.getInt("rate_30"));
		chart.setRate_40(rs.getInt("rate_40"));
		chart.setRate_50(rs.getInt("rate_50"));
		chart.setRate_m(rs.getInt("rate_m"));
		chart.setRate_w(rs.getInt("rate_w"));
		chart.setShow_code(rs.getString("show_code"));
		
		return chart;
	}
}
