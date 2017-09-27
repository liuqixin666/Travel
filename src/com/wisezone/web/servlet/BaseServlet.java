package com.wisezone.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//访问servlet时，输入的参数	http://localhost:8080/Travel/travelServlet?method=index
		String method = request.getParameter("method");
		if (null == method) {
			method = "index";
		}
		
		Class<? extends BaseServlet> claz = this.getClass();	//通过反射，获取继承BaseServlet的子类（TravelServlet）
		try {
			Method m = claz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);	//通过反射来获取TravelServlet中的index方法
			String path = (String) m.invoke(this, request,response);//通过Method对象的invoke方法，动态执行TravelServlet中的index方法
			//path就有可能是"index.jsp"
			if (null != path) {//判断path是否为空，因为有的方法不需要页面转发，直接在方法中就重定向到其他的页面或servlet，如果需要页面转发，则能得到一个路径
				//通过path指向的路径页面转发到某一个页面或servlet
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	public String index(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
}
