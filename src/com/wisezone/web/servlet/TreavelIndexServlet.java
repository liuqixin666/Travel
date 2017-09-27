package com.wisezone.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisezone.biz.TravelBiz;
import com.wisezone.biz.impl.TravelBizImpl;
import com.wisezone.entity.Travel;

/**
 * 我的脚印的首页Servlet
 * @author Administrator
 *
 */
public class TreavelIndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*调用业务逻辑层*/
	private TravelBiz biz = new TravelBizImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//通过业务逻辑层的方法查询所有的数据
		List<Travel> list = biz.queryAll();
		req.setAttribute("list", list);//将list集合存放到request作用域
		req.getRequestDispatcher("index.jsp").forward(req, resp);//页面转发
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	
}
