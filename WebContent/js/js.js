$(function(){
	$("button").click(function(){
		
		$.ajax({
			type:"post",
			url:"http://localhost:8080/Travel/travelServlet",
			data:"method=currentTime",
			success:function(str){
				alert(str);
			}
		});
		
		
	});
});

/**
 * 
 */

function fn_delete(tId){
	if(confirm("确认删除吗？")){
		window.location.href="http://localhost:8080/Travel/travelServlet?method=delete&tId="+tId;
	}
}

function fn_delete2(a){
	var tId = $(a).parents("tr").find("td:eq(0)").text();
	
	$.ajax({
		type:"post",
		dataType:"json", /*服务器返回的类型*/
		url:"http://localhost:8080/Travel/travelServlet",
		data:"method=delete_ajax&tId=" + tId,
		success:function(data){
			alert(data["msg"]);
			
			//从页面中移除被删除的数据
			var state = data["state"] || false;
			if(state){
				//删除成功,移除表格中的行
				$(a).parents("tr").remove();
			}
		}
	});
}
