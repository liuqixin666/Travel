package com.wisezone.entity;

import java.io.Serializable;
import java.sql.Date;

public class Travel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int tId;
	private String area;
	private Date time;
	private String felling;
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getFelling() {
		return felling;
	}
	public void setFelling(String felling) {
		this.felling = felling;
	}
	public Travel() {
		super();
	}
	public Travel(int tId, String area, Date time, String felling) {
		super();
		this.tId = tId;
		this.area = area;
		this.time = time;
		this.felling = felling;
	}
	
}
