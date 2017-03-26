
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

public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbconnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
        
        try {
            String query = "Select * from FAV_BOARD_GAMES";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable() {
        
        String table = "";
        table += "<table border=1";
        
        try {
            while(this.results.next()) {
                
                Games game = new Games();
                game.setGameID(this.results.getInt("GAMEID"));
                game.setGameName(this.results.getString("GAMENAME"));
                game.setPlayerNum(this.results.getString("NUMBEROFPLAYERS"));
                game.setAgeRecommend(this.results.getString("AGERECOMMENDATION"));
                game.setLengthPlay(this.results.getString("LENGTHOFPLAY"));
                
                
                table += "<br>";
                table += "<td>";
                table += game.getGameID();
                table += "</td>";
                
                table += "<td>";
                table += game.getGameName();
                table += "</td>";
                
                table += "<td>";
                table += game.getPlayerNum();
                table += "</td>";
                
                table += "<td>";
                table += game.getAgeRecommend();
                table += "</td>";
                
                table += "<td>";
                table += game.getLengthPlay();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=delete?gameID=" + game.getGameID() + "> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
            return table;
    }
}
