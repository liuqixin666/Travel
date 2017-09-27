package com.wisezone.test;

import java.util.List;

import org.junit.Test;

import com.wisezone.dao.TravelDao;
import com.wisezone.dao.impl.TravelDaoImpl;
import com.wisezone.entity.Travel;

public class TestTravel {
	
	@Test
	public void test1(){
		TravelDao dao = new TravelDaoImpl();
		List<Travel> list = dao.queryAll();
		for (Travel t : list) {
			System.out.println(t.gettId() + "," + t.getArea() + "," + t.getFelling());
		}
	}
}
