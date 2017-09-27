package com.wisezone.dao;

import java.util.List;

import com.wisezone.entity.Travel;

public interface TravelDao extends CommonDao<Travel> {
	public List<Travel> queryAll();
}
