package oo;

public class Square
{
	private int xAxis;
	private int yAxis;
	private boolean occupied = false;
	
	Square(int xAxis,int yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	
	public int getXAxis()
	{
		return xAxis;
	}
	
	public int getYAxis()
	{
		return yAxis;
	}
	public boolean getOccupied()
	{
		return occupied;
	}
	
	public void setOccupied(boolean occupied)
	{
		this.occupied = occupied;
	}
}
