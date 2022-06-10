package com.kos.showticat.ja0;

import java.util.List;

import com.kos.showticat.VO.CastVO;

public class CastService {
	CastDAO dao = new CastDAO();
	
	//출연배우 조회
	public List<CastVO> selectCast(String show_code) {
		return dao.selectCast(show_code);
	}
}
