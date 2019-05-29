package oo;

public class Player {

	private int score;
	private String name;
	private String pass;

	Player(String name, String pass) {
		this.name = name;
		this.pass = pass;
		this.score = 0;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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
		String mess = name + "." + pass + "." + score;
		return mess;
	}
	
	public boolean equal(String name, String pass)
	{
		
		if(this.name.equals(name)== true && this.pass.equals(pass)== true)
		{
			return true;
		}
		
		return false;
			
	}
}
