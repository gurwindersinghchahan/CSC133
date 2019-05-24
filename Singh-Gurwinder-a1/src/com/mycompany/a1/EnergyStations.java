package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
// Energy stations is a concret class of Fixed object class
public class EnergyStations extends FixedObject {
	
	
	private int capacity  ;// Energy stations have an attribute called capacity
	
	public EnergyStations (double xlocation, double ylocation, int size)// Constructor
	{
		super(xlocation, ylocation);// location is obtain from parent class that cannot be change
		this.setColor(ColorUtil.BLUE);
		this.setSize(size);
		this.setCapacity(size);
			
	}
	public void setCapacity(int capacity)// Setter method of  capacity
	{
		this.capacity = capacity;
	}
	public int getCapacity()// getter method of capacity
	{
		return capacity;
	}
	public String toString() // Display method
	{
		String parentDesc = super.toString();
		String myDesc = " capacity=" + capacity;
		return "EnergyStation:" + parentDesc + myDesc;
		
	}
	
	
	
}
