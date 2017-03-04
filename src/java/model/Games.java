/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nathan
 */
public class Games {
    
    private int gameID;
    private String gameName;
    private String playerNum;
    private String ageRecommend;
    private String lengthPlay;

    public Games() {
        this.gameID = 0;
        this.gameName = "";
        this.playerNum = "";
        this.ageRecommend = "";
        this.lengthPlay = "";
    }
    
    public Games(int gameID, String gameName, String playerNum, String ageRecommend, String lengthPlay) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.playerNum = playerNum;
        this.ageRecommend = ageRecommend;
        this.lengthPlay = lengthPlay;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(String playerNum) {
        this.playerNum = playerNum;
    }

    public String getAgeRecommend() {
        return ageRecommend;
    }

    public void setAgeRecommend(String ageRecommend) {
        this.ageRecommend = ageRecommend;
    }

    public String getLengthPlay() {
        return lengthPlay;
    }

    public void setLengthPlay(String lengthPlay) {
        this.lengthPlay = lengthPlay;
    }

    @Override
    public String toString() {
        return "Games{" + "gameID=" + gameID + ", gameName=" + gameName + ", playerNum=" + playerNum + ", ageRecommend=" + ageRecommend + ", lengthPlay=" + lengthPlay + '}';
    }
    
    
    
    
}
