package com.wisezone.web.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisezone.biz.TravelBiz;
import com.wisezone.biz.impl.TravelBizImpl;
import com.wisezone.entity.Travel;

/**
 * Servlet implementation class TravelAddServlet
 */
@WebServlet("/travelAddServlet")
public class TravelAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TravelAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    /*调用业务逻辑层*/
	private TravelBiz biz = new TravelBizImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String area = request.getParameter("area");
			String str_time = request.getParameter("time");
			String felling = request.getParameter("felling");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date d = sdf.parse(str_time);//根据字符串的日期转换成为java.util.Date
			Date time = new Date(d.getTime());
			Travel travel = new Travel(0, area, time, felling);
			
			int result = biz.add(travel);
			if (result > 0) {
				request.setAttribute("msg", "添加成功");
			}else{
				request.setAttribute("msg", "添加失败");
			}
			request.getRequestDispatcher("message.jsp").forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
