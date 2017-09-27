package com.wisezone.biz.impl;

import java.util.List;

import com.wisezone.biz.TravelBiz;
import com.wisezone.dao.TravelDao;
import com.wisezone.dao.impl.TravelDaoImpl;
import com.wisezone.entity.Travel;

public class TravelBizImpl implements TravelBiz {

	private TravelDao dao = new TravelDaoImpl();
	
	@Override
	public int add(Travel t) {
		return dao.add(t);
	}

	@Override
	public int update(Travel t) {
		return dao.update(t);
	}

	@Override
	public int deleteById(int tId) {
		return dao.deleteById(tId);
	}

	@Override
	public Travel findById(int tId) {
		return dao.findById(tId);
	}

	@Override
	public List<Travel> queryAll() {
		return dao.queryAll();
	}

}
