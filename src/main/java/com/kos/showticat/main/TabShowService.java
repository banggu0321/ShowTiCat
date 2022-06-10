package com.kos.showticat.main;

import java.util.List;

import com.kos.showticat.admin.vo.ShowVO;

public class TabShowService {
	TabShowDAO tabShowDAO = new TabShowDAO();
	// 1-1. chart movie
	public List<ShowVO> selectChartMovie() {
		return tabShowDAO.selectChartMovie();
	}
	// 1-2. chart performance
	public List<ShowVO> selectChartPer() {
		return tabShowDAO.selectChartPer();
	}
	// 2-1. screen movie
	public List<ShowVO> selectScreenMovie() {
		return tabShowDAO.selectScreenMovie();
	}
	// 2-2. screen performance
	public List<ShowVO> selectScreenPer() {
		return tabShowDAO.selectScreenPer();
	}
}
