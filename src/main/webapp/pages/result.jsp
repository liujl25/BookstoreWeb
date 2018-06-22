<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getContextPath()+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body onload="delayURL()">
	<c:if test="${result == true }">
		<h3>操作成功！</h3>
		<%-- <a href="${url }">点击返回</a> --%>
		<!-- 解决表单的重复提交问题的三种常用方法 -->
		<!-- 1.使用javascript客户端技术，解决表单的重复提交 -->
		<!-- 2.使用服务端的token标识进行判断 -->
		<!-- 3.使用服务端的重定向解决重复提交问题 -->
	</c:if>	
	<c:if test="${result == false }">
			<h3>操作失败！</h3>
		<%-- <a href="${url }">点击返回</a> --%>
	</c:if>
	系统将在 <span id="time">3</span> 秒钟后自动跳转至新网址，如果未能跳转，<a href="${url }" title="点击访问">请点击</a>。</p>  
	<script type="text/javascript">   
    function delayURL() {  
        var delay = document.getElementById("time").innerHTML;  
 		var t = setTimeout("delayURL()", 1000);  
        if (delay > 0) {  
            delay--;  
            document.getElementById("time").innerHTML = delay;  
        } else {  
    		 clearTimeout(t);  
            window.location.href = "${url}";  
        }        
    }  
</script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	
</script>
</body>
</html>