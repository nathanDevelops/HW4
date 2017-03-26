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
    </head>
    <body>
        <h1>Add A New Game</h1>
        
        <form name="addForm" action="addGame" method="get">
            
            <label>Game Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>Number of Players:</label>
            <input type="text" name="players" value="" />
            <br>
            <label>Suggested Age:</label>
            <input type="text" name="age" value="" />
            <br>
            <label>Length of Game:</label>
            <input type="text" name="time" value="" />
            <br>
            <input type="submit" name="submit" value="submit" />
        </form>
    </body>
</html>
