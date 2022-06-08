package com.kos.showticat.jayoung;

import java.util.List;

public class ShowService {
	ShowDAO dao = new ShowDAO();
	
	//공연목록 전체조회
	public List<ShowVO> selectAll() {
		return dao.selectAll();
	}
	
	//공연코드로 조회
	public ShowVO selectShow(String show_code) {
		return dao.selectShow(show_code);
	}

	//검색목록 전체조회
	public List<ShowVO> selectSearch(String word) {
		return dao.selectSearch(word);
	}
}
