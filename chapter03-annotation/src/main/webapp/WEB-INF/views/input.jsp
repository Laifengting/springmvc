<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加员工</title>
    </head>

    <body>
        <%--
        为什么使用 form 标签
            1. 可以更快速的开发出表单页面，页面可以更方便的进行表单值的回显
            2. 【注意】可以通过 ModelAttribute 属性指定绑定的模型属性，
                若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean，如果该属性值也不存在，则会发生错误。
        --%>
        <spring:form action="/employee/emp" method="POST" modelAttribute="employee">
            <%-- path 属性对应 html 表单标签的 name 属性值 --%>
            LASTNAME: <spring:input path="lastName"/> <br/>
            EMAIL:<spring:input path="email"/> <br/>
            <%
                Map<String, String> map = new HashMap<>();
                map.put("0", "女");
                map.put("1", "男");
                request.setAttribute("map", map);
            %>
            <%-- 多个单选框可以通过 delimiter 指定分隔符 --%>
            GENDER:
            <br/>
            <spring:radiobuttons path="gender" items="${map}" delimiter="<br/>"/> <br/>
            DEPARTMENT:<spring:select path="dept.deptName" items="${departments}" itemLabel="deptName" itemValue="deptName"/> <br/>
            <input type="submit" value="提交">
        </spring:form>

    </body>
</html>
