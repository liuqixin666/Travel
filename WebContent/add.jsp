<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加脚印</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/js/js.js"></script>
<script>
$(function(){
	$("form").submit(function(){
		var flag = true;
		
		/*遍历页面中所有的文本框以及文本域*/
		$("input[type='text'],textarea").each(function(index,item){
			var val = $(item).val();
			if(val == undefined || val == ""){
				flag = false;
				$(item).focus();//为空的标签获得焦点
				alert("请完善页面数据");
				return false;/*退出循环*/
			}
			
		});
		
		if (!flag) {
			return false;
		}
		
		var reg = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
		if (!reg.test($("#time").val())) {
			alert("请输入正确的时间格式");
			$("#time").focus();
			return false;
		}
		
		$("input[type='text'],textarea").each(function(){
			
		});
		return true;
	});
});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/travelServlet?method=add" method="post">
		<table>
			<tr align="center">
				<td colspan="2">
					<h4>添加脚印</h4>
				</td>
			</tr>
			<tr>
				<td>
					国家/地区:
				</td>
				<td>
					<input type="text" name="area" placeholder="请输入区域" />
				</td>
			</tr>
			<tr>
				<td>
					脚印时间:
				</td>
				<td>
					<input type="text" id="time" name="time" placeholder="请输入时间  格式(yyyy-mm-dd)" />
				</td>
			</tr>
			<tr>
				<td>
					所见所感:
				</td>
				<td>
					<textarea rows="10" cols="30" name="felling"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" />
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>