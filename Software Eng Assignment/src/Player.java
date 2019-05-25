
public class Player {

	private String playerId;
	private int score;
	private String colour;
	private String name;
	private String pass;

	Player(String playerId, String name, String pass) {
		this.playerId = playerId;
		this.name = name;
		this.pass = pass;
		this.score = 0;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String colour)
	{
		this.colour = colour;
	}
	public String getName() {
		return name;
	}


	public String getColour() {
		return colour;
	}

	public String getPlayerId() {
		return playerId;
	}
	public String getPlayerPass() {
		return pass;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public String toString() {
		String mess = playerId + name;
		return mess;
	}
	
	public boolean equal(String name, String pass)
	{
		
	if(this.name.equals(name)== true && this.pass.equals(pass)== true)
	{
		return true;
	}
	else
	{
		return false;
		
	}
	}
}
