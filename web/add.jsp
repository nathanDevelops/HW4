<%-- 
    Document   : add
    Created on : Mar 25, 2017, 8:05:06 PM
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Game</title>
        <link rel="stylesheet" type="text/css" href="gameCSS.css"/>
    </head>
    <body>
        <div class="center">
        
        <form name="addForm" action="addGame" method="get">
            <h3>Add a New Game</h3>
            <hr width="90%" color="white">
            
            <br>
            
            
                    <label>Game Name:</label>
                        <input type="text" name="name" value="" size="20" />
                    <br>
                    <label>Number of Players:</label>
                        <input type="text" name="players" value="" size="20" />
                    <br>
                    <label>Suggested Age:</label>
                        <input type="text" name="age" value="" size="20" />
                    <br>
                    <label>Length of Game:</label>
                        <input type="text" name="time" value="" size="20" />
                        <br>
                        <br>
                    <input type="submit" name="submit" value="submit" />
        </form>
        </div>
    </body>
</html>
