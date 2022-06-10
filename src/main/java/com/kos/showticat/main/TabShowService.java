package com.kos.showticat.main;

import java.util.List;

import com.kos.showticat.main.vo.ShowVO;


public class TabShowService {
	TabShowDAO tabShowDAO = new TabShowDAO();
	
	// 1. Chart
	// 1-1. Chart Movie
	public List<ShowVO> selectChartMovie() {
		return tabShowDAO.selectChartMovie();
	}
	// 1-2. Chart Performance
	public List<ShowVO> selectChartPer() {
		return tabShowDAO.selectChartPer();
	}
	// 2. Screen
	public List<ShowVO> selectScreenMovie() {
		return tabShowDAO.selectScreenMovie();
	}
	// 2-2. Screen Performance
	public List<ShowVO> selectScreenPer() {
		return tabShowDAO.selectScreenPer();
	}
}
