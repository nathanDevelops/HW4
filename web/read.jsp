
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="gameCSS.css"/>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    
    <body>
        <h1>List Of My Favorite Games</h1>
        <%= table %>
        <div style="text-align: center">
        <a href ="add">Add A New Games</a>
        </div>
    </body>
</html>
