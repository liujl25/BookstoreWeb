<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/17
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
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
<!-- 	<script src="bootstrap/js/bootstrap.js"></script> -->
	<script src="bootstrap/js/jquery-3.1.1.min.js"></script>
</head>
<body >
<div class="container">
	<c:if test="${errors != null }">
		输入有误:<br>
		<c:forEach items="${errors }" var="er">
            <c:out value="objname:${er.objectName}"/>
			<c:out value="message:${er.defaultMessage }"/></br>
		</c:forEach>
	</c:if>
    <div class="col-md-12 col-md-offset-3">
        <div class="col-md-offset-2"><h3>新增书籍</h3></div>
        <%--执行文件上传需要修改form表单的类型--%>
        <form id="add_form" enctype="multipart/form-data" action="book/doAdd.action" class="form-horizontal" role="form" method="post">
            <div class="form-group">
                <label  class="col-sm-1 control-label">版本号</label>
                <div class="col-sm-3">
                    <input id="isbn" name="isbn" type="text" class="form-control"  placeholder="请输入ISBN">
                    <span id="isbn_msg" class=""></span>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">书名</label>
                <div class="col-sm-3">
                    <input name="bookName" type="text" class="form-control"  placeholder="请输入书名">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">价格</label>
                <div class="col-sm-3">
                    <input  name="price" type="text" class="form-control"  placeholder="请输入价格">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">出版社</label>
                <div class="col-sm-3">
                    <input name="publisher"type="text" class="form-control"  placeholder="请输入出版社">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">出版社</label>
                <div class="col-sm-3">
                    <input name="publishDate" type="text" class="form-control"  placeholder="请输入出版时间">
                </div>
            </div>
            <div class="form-group">
                <%--文件上传时，文件域的名称不要与对象的字段名一致，因为他们的类型不一致，spring mvc 无法完成转换--%>
                    <label  class="col-sm-1 control-label">封面图片</label>
                    <div class="col-sm-3">
                        <input type="file" id="inputfile" name="imgfile" />
                    </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">上架类型</label>
                <div class="col-sm-3">
                    <select class="form-control" name="category.id">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.id }">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-md-push-1">
                    <button class="btn btn-default btn-md"   type="reset">重置</button>
                </div>
                <div class="col-md-3 col-md-push-0">
                    <button class="btn btn-default btn-md " id="add_btn"  type="submit">提交</button>
                </div>
            </div>          
        </form>
        <script type="text/javascript">
       		 $(document).ready(function(){//文档加载完毕后
        		$("#isbn").blur(function(){//监听失去焦点事件
        			//1.获取isbn的值
        			var tempIsbn = $("#isbn").val(); 
        			//2.校验数据后发送ajax的值
        			//使用json发送数据到服务器
        			$.post("book/findIsbn.action",{"isbn":tempIsbn},function(data){
        				//回调函数：当发送异步请求到服务器处理后 返回相关数据，浏览器自动调用回调很熟
        				//3.服务器返回查询结果后，提示用户
        				//alert(data);
        				// var d = eval(data);
                        var d = JSON.parse(data);
                        if(d.result){
        					$("#isbn_msg").text("书籍已经存在!");
        				}else{
        					$("#isbn_msg").text("书籍不存在!");
        				}
        				
        			});	
        		});
        	});
        </script>
    </div>
</div>
</body>
</html>