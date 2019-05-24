package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;

public class PlayerRobot extends Robots// Extending from robot class
{
	
	public PlayerRobot (double xlocation, double ylocation)//Constructor
	{
		super(xlocation, ylocation);
		this.setXlocation(xlocation);
		this.setYlocation(ylocation);
		this.setSize(40);
		this.setSpeed(0);
		this.setColor(ColorUtil.MAGENTA);
		
	}
	public String toString()// Display method for Player Robot
	{
		String parentDesc = super.toString();
		return "PlayerRobot:" + parentDesc;
	} 
}
	