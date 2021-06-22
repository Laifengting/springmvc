<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Spring MVC</title>
    </head>
    <body>
        <h1><%= "Hello World!" %>
        </h1>
        <br/>
        <a href="springmvc/helloworld">Hello World</a>
        <br/>
        <form action="springmvc/testMethod" method="post">
            <input type="submit" value="确认"/>
        </form>
        <br/>
        <a href="/springmvc/testParamHeaders?username=tom&age=10">Test Param</a>
        <br/>
        <a href="/springmvc/testAntPath/11111/abc">Test Ant Path</a>
        <br/>
        <a href="/springmvc/testPathVariable/1">Test Path Variable</a>
        <br/>
        <a href="/springmvc/testRest/1">Test Rest Get</a>

        <br/>
        <form action="/springmvc/testRest" method="post">
            <input type="submit" value="Test Rest Post"/>
        </form>

        <br/>
        <form action="/springmvc/testRest/1" method="post">
            <input type="hidden" name="_method" value="DELETE"/>
            <input type="submit" value="Test Rest DELETE"/>
        </form>

        <br/>
        <form action="/springmvc/testRest/1" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="Test Rest PUT"/>
        </form>

        <br/>
        <a href="/springmvc/testRequestParam?username=tom&age=20">Test Request Param</a>

        <br/>
        <a href="/springmvc/testReuqestHeaders">Test Request Headers</a>

        <br/>
        <a href="springmvc/testCookieValue">Test Cookie Value</a>

        <br/>
        <form action="springmvc/testPojo">
            <table>
                <tr>
                    <td>项目</td>
                    <td>名称</td>
                </tr>
                <tr>
                    <td>username:</td>
                    <td><input type="text" name="username" placeholder="用户名"></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><input type="password" name="password" placeholder="密码"></td>
                </tr>
                <tr>
                    <td>age:</td>
                    <td><input type="text" name="age" placeholder="年龄"></td>
                </tr>
                <tr>
                    <td>email:</td>
                    <td><input type="text" name="email" placeholder="邮箱"></td>
                </tr>
                <tr>
                    <td>province:</td>
                    <td><input type="text" name="address.province" placeholder="省"></td>
                </tr>
                <tr>
                    <td>city:</td>
                    <td><input type="text" name="address.city" placeholder="市"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>

        <br/>
        <a href="springmvc/testServletApi">Test Servlet API</a>

        <br/>
        <a href="springmvc/testModelAndView">Test ModelAndView</a>

        <br/>
        <a href="springmvc/testMap">Test Map</a>

        <br/>
        <a href="springmvc/testSessionAttributes">Test Session Attributes</a>

        <br/>
        <form action="/springmvc/testModelAttribute" method="post">
            <input type="hidden" name="id" value="1">
            username: <input type="text" name="username" value="Tom"><br/>
            email: <input type="text" name="email" value="tom@qq.com"/><br/>
            age: <input type="text" name="age" value="20"><br/>
            <input type="submit" value="提交">
        </form>

        <%--<br/>--%>
        <%--<fm:form action="register" method="post">--%>
        <%--    <spring:message code="i18n.loginName"/>：<fm:input path="loginName"/><br/><br/>--%>
        <%--    <spring:message code="i18n.password"/>：<fm:input path="password"/><br/><br/>--%>
        <%--    <spring:message code="i18n.age"/>：<fm:input path="age"/><br/><br/>--%>
        <%--    <spring:message code="i18n.email"/>：<fm:input path="email"/><br/><br/>--%>
        <%--    <spring:message code="i18n.phone"/>：<fm:input path="phone"/><br/><br/>--%>
        <%--    <input type="submit" value="<spring:message code="i18n.submit"/>">--%>
        <%--</fm:form>--%>

        <a href="/springmvc/testView">Test View</a>
    </body>
</html>
