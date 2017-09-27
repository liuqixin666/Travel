package com.wisezone.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wisezone.dao.TravelDao;
import com.wisezone.entity.Travel;
import com.wisezone.util.DataSourceUtil;

public class TravelDaoImpl implements TravelDao{

	private QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
	
	@Override
	public int add(Travel t) {
		String sql = "insert into travel (tid,area,t_time,felling) values(travel_seq.nextval,?,?,?)";
		try {
			return qr.update(sql, t.getArea(),t.getTime(),t.getFelling());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Travel t) {
		
		return 0;
	}

	@Override
	public int deleteById(int tId) {
		String sql = "delete from travel where tid=?";
		try {
			return qr.update(sql,tId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Travel findById(int tId) {
		String sql = "select tid,area,t_time time,felling from travel where tid=?";
		try {
			return qr.query(sql, new BeanHandler<Travel>(Travel.class),tId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Travel> queryAll() {
		String sql = "select tid,area,t_time time,felling from travel";
		
		try {
			return qr.query(sql, new BeanListHandler<Travel>(Travel.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
