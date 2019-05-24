package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;


public class NonPlayerRobot extends Robots {
	
	public NonPlayerRobot(double xlocation, double ylocation)//Constructor
	{
		super(xlocation, ylocation);
		this.setXlocation(xlocation);
		this.setYlocation(ylocation);
		this.setSize(25);
		this.setSpeed(3);
		this.setColor(ColorUtil.GREEN);
	
	}
	
	public void NprCollisionWithRobot() // collsion with robot
	{
		super.setDamageLevel (15) ;		
		super.setColor(ColorUtil.rgb(255 - (20 *(10 - this.getDamageLevel())) , 0, 0));		
		super.updateRobotsSpeed();
	}

	public String toString()
	{
		String parentDesc= super.toString();
		return "NonPlayerRobot: "  + parentDesc; 
	}
}
		
