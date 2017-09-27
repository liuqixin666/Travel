package com.wisezone.biz;

import java.util.List;

import com.wisezone.entity.Travel;

public interface TravelBiz extends CommonBiz<Travel> {
	public List<Travel> queryAll();
}
