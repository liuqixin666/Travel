package com.wisezone.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.wisezone.dao.TravelDao;
import com.wisezone.dao.impl.TravelDaoImpl;
import com.wisezone.entity.Travel;

import net.sf.json.JSONObject;

public class TestTravel {
	
	@Test
	@Ignore
	public void test1(){
		TravelDao dao = new TravelDaoImpl();
		List<Travel> list = dao.queryAll();
		for (Travel t : list) {
			System.out.println(t.gettId() + "," + t.getArea() + "," + t.getFelling());
		}
	}
	
	@Test
	@Ignore
	public void test2(){
		Map<String, Object> map = new HashMap<>();
		map.put("tId", 1001);
		map.put("area", "重庆市");
		map.put("time", "2017-09-28");
		map.put("felling", "重庆是一个大火炉");
		
		JSONObject json = new JSONObject();
		json.put("rows", map);
		String str = json.toString();
		System.out.println(str);
	}
	
	@Test
	@Ignore
	public void test3(){
		List<Travel> list = new ArrayList<>();
		list.add(new Travel(1001, "重庆", null, "重庆是一个大火炉"));
		list.add(new Travel(1002, "杭州", null, "天堂"));
		
		JSONObject json = new JSONObject();
		json.put("rows", list);
		
		String str = json.toString();
		System.out.println(str);
		
	}
	
	@Test
	public void test4(){
		Map<String, Object> map = new HashMap<>();
		map.put("tId", 1001);
		map.put("area", "重庆市");
		map.put("time", "2017-09-28");
		map.put("felling", "重庆是一个大火炉");
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("tId", 1002);
		map2.put("area", "杭州");
		map2.put("time", "2017-09-28");
		map2.put("felling", "天堂");
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map2);
		list.add(map);
		
		JSONObject json = new JSONObject();
		json.put("rows", list);
		
		String str = json.toString();
		System.out.println(str);
	}
}
