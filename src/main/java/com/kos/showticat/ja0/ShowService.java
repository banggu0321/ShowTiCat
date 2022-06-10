package com.kos.showticat.ja0;

import java.util.List;

import com.kos.showticat.VO.ShowVO;

public class ShowService {
	ShowDAO dao = new ShowDAO();
	
	//공연목록 전체조회
	public List<ShowVO> selectAll() {
		return dao.selectAll();
	}
	
	//영화/공연 각자 목록
	public List<ShowVO> selectCategory(String category) {
		return dao.selectCategory(category);
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
