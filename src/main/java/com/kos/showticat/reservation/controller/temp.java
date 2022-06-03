package com.kos.showticat.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.reservation.service.ScheduleService;
import com.kos.showticat.reservation.vo.ScheduleVO;

public class temp {

	public static void main(String[] args) {
		
		ScheduleService service = new ScheduleService();
		
		List<ScheduleVO> scList = new ArrayList<>();
		scList = service.selectALL();
		
		for(ScheduleVO arr: scList) {
			System.out.println(arr);
		}
	}

}
