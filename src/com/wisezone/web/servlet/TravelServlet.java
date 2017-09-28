package com.wisezone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisezone.biz.TravelBiz;
import com.wisezone.biz.impl.TravelBizImpl;
import com.wisezone.entity.Travel;

import net.sf.json.JSONObject;

public class TravelServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TravelBiz biz = new TravelBizImpl();
	
	@Override
	public String index(HttpServletRequest request, HttpServletResponse response) {
		List<Travel> list = biz.queryAll();//查询所有的数据
		
		request.setAttribute("list", list);
		
		return "index2.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String str_tId = request.getParameter("tId");
		if (null == str_tId) {
			request.setAttribute("msg", "页面参数有误");
		}else{
			int tId = Integer.parseInt(str_tId);
			int result = biz.deleteById(tId);
			String msg = result > 0 ?"删除成功":"删除失败";
			
			responseScript(request, response, msg);
			return null;
			
		}
		return "message.jsp";
	}
	
	public String delete_ajax(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String str_tId = request.getParameter("tId");
		
		response.setContentType("text/html;charset=utf-8");
		if (null == str_tId) {
			PrintWriter out = response.getWriter();
			
			JSONObject json = new JSONObject();
			json.put("msg", "页面参数有误");
			
			out.print(json.toString());
			out.flush();
			out.close();
		}else{
			int tId = Integer.parseInt(str_tId);
			int result = biz.deleteById(tId);
			String msg = result > 0 ?"删除成功":"删除失败";
			
			PrintWriter out = response.getWriter();
			
			JSONObject json = new JSONObject();
			json.put("msg", msg);
			json.put("state", result > 0);
			
			out.print(json.toString());
			out.flush();
			out.close();
			return null;
			
		}
		return "message.jsp";
	}

	private void responseScript(HttpServletRequest request, HttpServletResponse response, String msg)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('" + msg +"');");//alert() 会阻断它之后的代码
		out.print("window.location.href='" + request.getContextPath() + "/travelServlet'");//通过javascript的方式跳转到首页
		out.print("</script>");
		out.flush();//刷新缓存
		out.close();
	}
	
	public String add(HttpServletRequest request, HttpServletResponse response){
		try {
			String area = request.getParameter("area");
			String str_time = request.getParameter("time");
			String felling = request.getParameter("felling");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date d = sdf.parse(str_time);//根据字符串的日期转换成为java.util.Date
			Date time = new Date(d.getTime());
			Travel travel = new Travel(0, area, time, felling);
			
			int result = biz.add(travel);
			String msg = "";
			if (result > 0) {
				msg = "添加成功";
			}else{
				msg = "添加失败";
			}
			
			responseScript(request, response, msg);
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "add.jsp";
	}
	
	public String currentTime(HttpServletRequest request, HttpServletResponse response) throws IOException{
		java.util.Date date = new java.util.Date();//当前系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = sdf.format(date);	//将时间转换成为字符串
		
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
		return null;
	}
}
