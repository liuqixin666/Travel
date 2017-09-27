
/**
 * 
 */

function fn_delete(tId){
	if(confirm("确认删除吗？")){
		window.location.href="http://localhost:8080/Travel/travelServlet?method=delete&tId="+tId;
	}
}

