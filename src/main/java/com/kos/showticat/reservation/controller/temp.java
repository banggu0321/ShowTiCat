package com.kos.showticat.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.reservation.service.ScheduleService;
import com.kos.showticat.reservation.vo.MembersVO;
import com.kos.showticat.reservation.vo.ScheduleVO;

public class temp {

	public static void main(String[] args) {
		
		ScheduleService service = new ScheduleService();
		
		List<MembersVO> list = new ArrayList<>();
		list = service.selectALLMembers();
		
		for(MembersVO arr: list) {
			System.out.println(arr);
		}
	}

}
