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

</head>
<body >
<div class="container">

    <div class="col-md-12 col-md-offset-3">
        <div class="col-md-offset-2"><h3>编辑书籍</h3></div>
        <form id="add_form" action="book/doedit.action" class="form-horizontal" role="form" method="post">
            <div class="form-group">
                <label  class="col-sm-1 control-label">版本号</label>
                <div class="col-sm-3">
                    <input name="isbn" value="${book.isbn}" type="text" class="form-control" readonly>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">书名</label>
                <div class="col-sm-3">
                    <input name="bookName" value="${book.bookName}" type="text" class="form-control"  >
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">价格</label>
                <div class="col-sm-3">
                    <input  name="price" value="${book.price}" type="text" class="form-control" >
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">出版社</label>
                <div class="col-sm-3">
                    <input name="publisher" value="${book.publisher}" type="text" class="form-control" >
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">出版时间</label>
                <div class="col-sm-3">
                    <input name="publishDate" value="${book.publishDate}" type="text" class="form-control"  >
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-1 control-label">上架类型</label>
                <div class="col-sm-3">
                    <select class="form-control" name="category.id">
                        <c:forEach items="${categoryList}" var="category">
                            <option
                                    <c:if test="${category.id == book.category.id}">selected="true"</c:if> value="${category.id }">${category.name}</option>
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
    </div>
</div>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/jquery-3.1.1.min.js"></script>
</body>
</html>