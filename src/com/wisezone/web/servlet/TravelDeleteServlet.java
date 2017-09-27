package com.wisezone.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisezone.biz.TravelBiz;
import com.wisezone.biz.impl.TravelBizImpl;

/**
 * Servlet implementation class TravelDeleteServlet
 */
@WebServlet("/travelDel")
public class TravelDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*调用业务逻辑层*/
	private TravelBiz biz = new TravelBizImpl();
	
    public TravelDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_tId = request.getParameter("tId");
		if (null == str_tId) {
			request.setAttribute("msg", "页面参数有误");
		}else{
			int tId = Integer.parseInt(str_tId);
			int result = biz.deleteById(tId);
			request.setAttribute("msg", result > 0 ?"删除成功":"删除失败");
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
