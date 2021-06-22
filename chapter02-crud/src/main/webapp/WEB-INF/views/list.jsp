<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>员工列表</title>
        <%--
        1. 需要在 SpringMVC 配置处理静态资源
            优雅的 REST 风格的资源 URL 不希望带 .html 或 .do 等后缀
            若将 DispatcherServlet 请求映射配置为 "/"，则 SpringMVC 将捕获 WEB 容器的所有请求，包括静态资源的请求。
            SpringMVC 会将他们当成一个普通请求处理。因找不到对应处理器将导致报错。
        2. 解决：
            在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler /> 的方式解决静态资源无法加载的问题。
        --%>
        <script type="text/javascript" src="../static/js/jquery-3.6.0.min.js"></script>
        <script type="text/javascript">
            $(function () {
                alert("Hello jQuery")
                $(".delete").click(function () {
                    var href = $(this).attr("href")
                    $("#deleteEmployee").attr("action", href).submit();
                    return false;
                });
            })
        </script>
    </head>

    <body>
        <c:if test="${empty requestScope.employees}">
            没有任何员工信息。
        </c:if> <br/>
        <c:if test="${!empty requestScope.employees}">
            <table border="1" cellpadding="10" cellspacing="0">
                <tr align="center">
                    <th>ID</th>
                    <th>LASTNAME</th>
                    <th>EMAIL</th>
                    <th>GENDER</th>
                    <th>DEPARTMETN</th>
                    <th>EDIT</th>
                    <th>DELETE</th>
                </tr>
                <c:forEach items="${requestScope.employees}" var="emp">
                    <tr align="center">
                        <td>${emp.id}</td>
                        <td>${emp.lastName}</td>
                        <td>${emp.email}</td>
                        <td>${emp.gender == 0 ? '女' : '男'}</td>
                        <td>${emp.dept.deptName}</td>
                        <td><a href="">EDIT</a></td>
                        <td><a href="/employee/emp/${emp.id}">DELETE</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if> <br/>
        <a href="/employee/emp">添加员工</a>

        <form id="deleteEmployee" action="" method="post">
            <input type="hidden" name="_method" value="DELETE">
        </form>

    </body>
</html>
