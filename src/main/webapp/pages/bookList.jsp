<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/17
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //使用base标签解决网页的相对路径问题
    //网站的相对路径问题
    String basePath = request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/jquery-3.1.1.min.js"></script>
    <style>
        body{
            padding: 50px;
        }
    </style>
</head>
<body >
    <div class="container">
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation" >
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">书籍列表页面</a>
                </div>
                <div class="pull-right">
                    <form id="search_form" action="book/list.action" method="post" class="navbar-form navbar-left" role="search">
                       
                        <div class="form-group">
                            <input name="bookName" type="text" value="${book.bookName }" "form-control" placeholder="输入书名">
                        </div>
                        <button type="submit" class="btn btn-default">查询</button>
                    </form>
                    <button type="button" onclick="toadd()" class="btn btn-default navbar-btn">
                      		  新增书籍
                    </button>
                </div>
            </div>
        </nav>
        <div id="booklist" >
            <table class="table table-striped table-bordered table-hover table-condensed" >
                <tbody >
                <tr >
                    <th>ISBN</th>
                    <th>书籍名称</th>
                    <th>价格</th>
                    <th>出版社</th>
                    <th>出版时间</th>
                    <th>封面图片</th>
                    <th>分类</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pager.results}" var="book">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.bookName}</td>
                        <td>${book.price}</td>
                        <td>${book.publisher}</td>
                        <td>${book.publishDate}</td>
                        <td><img src="${book.bookImage}" alt="封面图片" height="60px" class="img-rounded"/></td>
                        <td>${book.category.name}</td>
                        <td>
                            <a href="book/toedit.action?isbn=${book.isbn}">修改</a>
                            <a href="javascript:void(0);" onclick="todelete('${book.isbn}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="col-md-6 col-md-offset-3" style="text-align: center">
            <ul class="pagination">
                <%--如果是第一页,不允许点击--%>
                <c:choose>
                    <c:when test="${pager.currentPage == 1}">
                        <li class="disabled">
                            <a  aria-label="Previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <%-- 点击到上页--%>
                        <li>
                            <a href="javascript:void(0)" onclick="tolist(${pager.getPrePage()})" aria-label="Previous">
                                上一页
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <%--显示5页中间页[begin=起始页,end=最大页]--%>
                <%--总页数没有5页--%>
                <c:choose>
                    <c:when test="${pager.getPages() <= 5}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="${pager.getPages()}"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="begin" value="${pager.currentPage-1}"/>
                        <c:set var="end" value="${pager.currentPage+3}"/>
                        <%--如果begin减1后为0,设置起始页为1,最大页为5--%>
                        <c:if test="${begin -1 <= 0}">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="5"/>
                        </c:if>
                        <%--如果end超过最大页,设置起始页=最大页-5--%>
                        <c:if test="${end > pager.getPages()}">
                            <c:set var="begin" value="${ pager.getPages() - 4}"/>
                            <c:set var="end" value="${ pager.getPages()}"/>
                        </c:if>
                    </c:otherwise>
                </c:choose>
                <%--遍历--%>
                <c:forEach var="i" begin="${begin}" end="${end}">
                    <%--当前页,选中--%>
                    <c:choose>
                        <c:when test="${i == pager.currentPage}">
                            <li class="active"><a href="javascript:void(0)" onclick="tolist(${i})">${i}</a></li>
                        </c:when>
                        <%--不是当前页--%>
                        <c:otherwise>
                            <li><a href="javascript:void(0)" onclick="tolist(${i})">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <%--如果是最后一页,不允许点击--%>
                <c:choose>
                    <c:when test="${pager.currentPage == pager.getPages() or pager.getPages()==0}">
                        <li class="disabled">
                            <a  aria-label="Previous">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <%-- 点击到下页--%>
                        <li>
                            <a href="javascript:void(0)" onclick="tolist(${pager.getNextPage()})" oncaria-label="Next">下一页</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
            <p>总页数:${pager.getPages()},共${pager.total}条记录</p>
        </div>
    </div>

    <script type="text/javascript">
        function todelete(bookIsbn){
            if(confirm("删除该书？")){
                location.href="book/delete.action?isbn="+bookIsbn;
            }
        }
        function toadd() {
            location.href="book/toAdd.action";
        }
        function tolist(currentPage){
        	$("#search_form").attr('action',"book/list.action?currentPage="+currentPage);
        	$("#search_form").submit();
        }
    </script>
</body>
</html>
