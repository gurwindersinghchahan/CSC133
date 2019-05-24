package com.mycompany.a2;
import java.util.Random;

public abstract class MovableObject extends GameObject
{
	private int heading;
	protected int speed ; // Drone class is accessing 
	
	public MovableObject(int heading) 
	{
		this.heading= heading;
	}
	public void move ()// This method updates the location of movable object based on its current heading and speed
	{

		double deltaX = (Math.cos(Math.toRadians(90 - this.getHeading())) * this.getSpeed());
		double deltaY = (Math.sin(Math.toRadians(90 - this.getHeading())) * this.getSpeed());
		this.setXlocation(this.getXlocation() + (float)deltaX);
		this.setYlocation(this.getYlocation() + (float)deltaY);
	}
	public void setSpeed(int speed)// setter method for speed
	{
		this.speed = speed;
	}
	public int getSpeed()// Getter method for speed
	{
		return speed;
	}
	public void setHeading(int heading)// setter method for heading
	{
		this.heading = heading;
	}
	public int getHeading()// getter method for heading
	{
		return heading;
	}
	public void changeHeading(int heading)
	{
		if (this instanceof ISteerable)
		{
			this.heading= heading;
		}
	}
	public String toString() // Display method
	{
		String parentDesc = super.toString();
		String myDesc = " heading=" + heading + " speed=" + speed ;
		return parentDesc + myDesc;
	}

}



