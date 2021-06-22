<%--
  Created by IntelliJ IDEA.
  User: Laifengting
  Date: 2021-06-09
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Success</title>
    </head>

    <body>
        <h4>SUCCESS PAGE</h4> <br/>

        time :${requestScope.time} <br/>

        names :${requestScope.names}<br/>

        request user : ${requestScope.user}<br/>

        session user : ${sessionScope.user}<br/>

        request school : ${requestScope.school}<br/>

        session school : ${sessionScope.school}<br/>

        <a href="/springmvc/testForward">Test Forward</a> <br/>
        
        <a href="/springmvc/testRedirect">Test Redirect</a> <br/>
    </body>
</html>
