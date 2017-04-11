
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Games"%>
<% Games game = (Games) request.getAttribute("game"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Game</title>
        <link rel="stylesheet" type="text/css" href="gameCSS.css"/>
    </head>
    <body>
        <div class="wrap">
            
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
            
            <div class="main">
     
                <div class="center">

                <form name="updateForm" action="updateGame" method="get">
                    <h3>Update a Game</h3>
                    <hr width="90%" color="white">

                    <br>
                            <label>Game ID:</label>
                            <input type="text" name="id" value="<%= game.getGameID() %>"  size="20" readonly/>
                            <br>
                            <label>Game Name:</label>
                            <input type="text" name="name" value="<%= game.getGameName() %>" size="20" />
                            <br>
                            <label>Number of Players:</label>
                                <input type="text" name="players" value="<%= game.getPlayerNum() %>" size="20" />
                            <br>
                            <label>Suggested Age:</label>
                                <input type="text" name="age" value="<%= game.getAgeRecommend() %>" size="20" />
                            <br>
                            <label>Length of Game:</label>
                                <input type="text" name="time" value="<%= game.getLengthPlay() %>" size="20" />
                                <br>
                                <br>
                            <div style="text-align: center">
                            <input type="submit" name="submit" value="Update" />
                            </div>
                    </form>
                </div>
        </div>
            <%@ include file="includes/footer.jsp" %>
        </div>
    </body>
</html>
