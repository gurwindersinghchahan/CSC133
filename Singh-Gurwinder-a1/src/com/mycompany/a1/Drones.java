package com.mycompany.a1;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class Drones extends MovableObject {
	
	Random rand = new Random();
	
	//Constructor
	public Drones (double xLocation, double yLocation,int speed, int size, int heading)
	{
		super(heading);
		this.setXlocation(xLocation);
		this.setYlocation(yLocation);
		super.setSize(size);
		super.setColor(ColorUtil. BLUE);
		this.speed = speed;
	
	}
	public void randomHeading()//heading of drones should be random value between 0 and 359
	{
		this.setHeading(rand.nextInt(359));
	}
	public void setSize(int size){}
	public void setColor(int color) {}
	public String toString() // Display method
	{
		String parentDesc = super.toString();
		return "Drone:" + parentDesc;
	
	}
	

}
