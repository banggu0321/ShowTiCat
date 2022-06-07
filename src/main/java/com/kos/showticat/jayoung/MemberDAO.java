package com.kos.showticat.jayoung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.util.DBUtil;

public class MemberDAO {
	static final String SQL_SELECT_ALL = "select * from MEMBERS order by 1 desc";
	static final String SQL_SELECT_POINT = "select m_name,point from members where m_name  = ?";
	static final String SQL_SELECT_PLACE = "select m_name,place_num from members where m_name  = ?";

	static final String SQL_LOGIN = "select * from members where m_id=? and m_pw=?";
	static final String SQL_FIND_ID = "select * from members where m_name=? and phone=?";
	static final String SQL_FIND_PW = "select * from members where m_id=? and m_name=? and phone=?";
	static final String SQL_SELECT_ID = "select count(*) from members where m_id=?";
	static final String SQL_INSERT = "insert into members values(?,?,?,?,?,?,?,sysdate,0,null)";
	static final String SQL_UPDATE_PW = "update members set m_pw = ? where m_id = ?";

	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int result;

	// 로그인
	public MemberVO selectID(String m_id, String m_pw) {
		MemberVO member = null;
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_LOGIN);
			pst.setString(1, m_id);
			pst.setString(2, m_pw);
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

	// 아이디 찾기
	public MemberVO findID(String m_name, String phone) {
		MemberVO member = null;
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_FIND_ID);
			pst.setString(1, m_name);
			pst.setString(2, phone);
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

	// 비밀번호 찾기
	public MemberVO findPW(String m_id, String m_name, String phone) {
		MemberVO member = null;
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_FIND_PW);
			pst.setString(1, m_id);
			pst.setString(2, m_name);
			pst.setString(3, phone);
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

	// 비밀번호 바꾸기
	public int resetPW(String m_id, String m_pw) {
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_FIND_PW);
			pst.setString(1, m_pw);
			pst.setString(2, m_id);
			rs = pst.executeQuery();

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// ID 중복확인
	public int checkID(String m_id) {
		int result = 0;
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_SELECT_ID);
			pst.setString(1, m_id);
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

	// 회원가입
	public int memberInsert(MemberVO member) {
		int result = 0;
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_INSERT);
			pst.setString(1, member.getM_id());
			pst.setString(2, member.getM_pw());
			pst.setString(3, member.getM_name());
			pst.setString(4, member.getEmail());
			pst.setString(5, member.getPhone());
			pst.setDate(6, member.getBirth());
			pst.setString(7, member.getGender());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

/////////////////////////////////////////////////////////////////////
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
			DBUtil.dbClose(rs, st, conn);
		}
		return member;
	}

/////////////////////////////////////////////////////////////////////
///////////////////////////이름으로 포인트 검색///////////////////////////
	public MemberVO selectByPlace(String m_name, String place_num) {
		MemberVO member = null;
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(SQL_SELECT_POINT);
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
			DBUtil.dbClose(rs, st, conn);
		}
		return member;
	}
/////////////////////////////////////////////////////////////////////

	private MemberVO makeMember(ResultSet rs) throws SQLException {
		MemberVO member = new MemberVO();

		member.setBirth(rs.getDate("birth"));
		member.setEmail(rs.getString("email"));
		member.setGender(rs.getString("gender"));
		member.setM_date(rs.getDate("m_date"));
		member.setM_id(rs.getString("m_id"));
		member.setM_name(rs.getString("m_name"));
		member.setM_pw(rs.getString("m_pw"));
		member.setPhone(rs.getString("phone"));
		member.setPlace_num(rs.getInt("place_num"));
		member.setPoint(rs.getInt("point"));

		return member;
	}
}
