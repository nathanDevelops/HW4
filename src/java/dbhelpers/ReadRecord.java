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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Games;

/**
 *
 * @author Nathan
 */
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Games game = new Games();
    private int gameID;
    
    public ReadRecord (int gameID){
    
    Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbconnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        
        this.gameID = gameID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
    
        try {
            String query = "SELECT * FROM FAV_BOARD_GAMES WHERE GAMEID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, gameID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            game.setGameID(this.results.getInt("GAMEID"));
            game.setGameName(this.results.getString("GAMENAME"));
            game.setPlayerNum(this.results.getString("NUMBEROFPLAYERS"));
            game.setAgeRecommend(this.results.getString("AGERECOMMENDATION"));
            game.setLengthPlay(this.results.getString("LENGTHOFPLAY"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
    public Games getGame(){
        
        return this.game;
    }
}
