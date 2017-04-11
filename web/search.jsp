<%-- 
    Document   : search
    Created on : Apr 3, 2017, 6:55:30 PM
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Games</title>
        <link rel="stylesheet" type="text/css" href="gameCSS.css"/>
    </head>
    <body>
        <div class="wrap">
            
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
            
            <div class="main">
                <div class="center">
                <h1>Search Games</h1>

                <form name="searchForm" action="search" method="get">

                    <input type="text" name="searchVal" value="" />

                    <br><br>

                    <input type="submit" name="submit" value="Search" />

                </form>
                </div>
        </div>
            <%@ include file="includes/footer.jsp" %>
        </div>
   </body>
</html>
