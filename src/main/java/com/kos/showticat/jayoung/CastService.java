package com.kos.showticat.jayoung;

import java.util.List;

public class CastService {
	CastDAO dao = new CastDAO();
	
	//출연배우 조회
	public List<CastVO> selectCast(String show_code) {
		return dao.selectCast(show_code);
	}
}
