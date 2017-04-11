/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Games;

/**
 *
 * @author Nathan
 */
public class UpdateQuery {
    
    private Connection conn;
    
    public UpdateQuery(){
        
         Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbconnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doUpdate (Games game){
        
        try {
            String query = "UPDATE FAV_BOARD_GAMES SET GAMENAME = ?, NUMBEROFPLAYERS = ?, AGERECOMMENDATION = ?, LENGTHOFPLAY = ? WHERE GAMEID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, game.getGameName());
            ps.setString(2, game.getPlayerNum());
            ps.setString(3, game.getAgeRecommend());
            ps.setString(4, game.getLengthPlay());
            ps.setInt(5, game.getGameID());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
