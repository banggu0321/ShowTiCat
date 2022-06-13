package com.kos.showticat.jaeyong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.util.DBUtil;

public class MemberDAO {
	static final String SQL_SELECT_ALL = "select * from members order by 1 desc";
	static final String SQL_UPDATE_MEMBER ="update members set m_pw=?,m_name=?,email=?,phone=?,birth=?,gender=? where m_id =?";
	static final String SQL_SELECT_POINT = "select m_name,point from members where m_name=?";
	static final String SQL_SELECT_PLACE = "select m_name,place_num from members where m_name=?";
	static final String SQL_UPDATE_PLACE = "update members set place_num=? where m_name=?";
	static final String SQL_DELETE_MEMBER = "delete from members where m_id =?";

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;


/////////////////////////////////////////////////////////////////////
/////////////////////////////테스트//////////////////////////////
	public List<MemberVO>selectAll() {
		List<MemberVO> mlist = new ArrayList<>();
		MemberVO member = null;
		conn = DBUtil.getConnection();
		System.out.println(conn);
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pst.executeQuery();
			while(rs.next()) {
				member = makeMember(rs);
				mlist.add(member);
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}		
		return mlist;
	}
/////////////////////////////////////////////////////////////////////
/////////////////////////////개인정보 수정//////////////////////////////
	public int memberUpdate(MemberVO member) {
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE_MEMBER);
            pst.setString(1, member.getM_pw());
            pst.setString(2, member.getM_name());
            pst.setString(3, member.getEmail());
            pst.setString(4, member.getPhone());
            pst.setDate(5, member.getBirth());
            pst.setString(6, member.getGender());
            pst.setString(7, member.getM_id());
            
			result = pst.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}		
		return result;
	}
///////////////////////////이름으로 포인트 검색///////////////////////////
	public MemberVO selectByPoint(String m_name, int point) {
		MemberVO member = null;
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_SELECT_POINT);
			pst.setString(1, m_name);
			pst.setInt(2, point);
			System.out.println(pst.toString());
			rs = pst.executeQuery();

			while (rs.next()) {
				member = makeMember(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return member;
	}

/////////////////////////////////////////////////////////////////////
///////////////////////////이름으로 포인트 검색///////////////////////////
	public MemberVO selectByPlace(String m_name, String place_num) {
		MemberVO member = null;
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_SELECT_PLACE);
			pst.setString(1, m_name);
			pst.setString(2, place_num);
			System.out.println(pst.toString());
			rs = pst.executeQuery();

			while (rs.next()) {
				member = makeMember(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return member;
	}
	
/////////////////////////////////////////////////////////////////////
///////////////////////////////회원탈퇴////////////////////////////////
	public int Delete(String m_id) {
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE_MEMBER);
            pst.setString(1,m_id);
            result = pst.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}		
		return result;
	}
/////////////////////////////////////////////////////////////////////

	private MemberVO makeMember(ResultSet rs) throws SQLException {
		MemberVO member = new MemberVO();

		member.setM_id(rs.getString("m_id"));
		member.setM_pw(rs.getString("m_pw"));
		member.setM_name(rs.getString("m_name"));
		member.setEmail(rs.getString("email"));
		member.setPhone(rs.getString("phone"));
		member.setBirth(rs.getDate("birth"));
		member.setGender(rs.getString("gender"));
		member.setM_date(rs.getDate("m_date"));
		member.setPoint(rs.getInt("point"));
		member.setPlace_num(rs.getInt("place_num"));

		return member;
	}
}
