
public class Player {

    public String playerId;
    public int score;
    public String colour;
    public String name;
    
    Player(String playerId, String name, String colour)
    {
    	this.playerId = playerId;
    	this.name = name;
    	this.colour = colour;
    	
    	this.score = 0;		
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setColour(String colour) {
    	this.colour = colour;
    }
    
    public String getColour() {
    	return colour;
    }
    
    public String getPlayerId() {
    	return playerId;
    }
    
    public int getScore()
    {
    	return score;
    }
    
    public void setScore(int score)
    {
    	this.score = score;
    }
}
