package com.mycompany.a1;

public abstract class FixedObject extends GameObject 
{
	
	public FixedObject(double xlocation, double ylocation) //All fixed objects are not allowed are not allowed to change location once they are created
	{
		super.setXlocation(xlocation);
		super.setYlocation(ylocation);
	}
	
	public void setXlocation(double xlocation) {}// Making sure location cannot be changed
	public void setYlocation(double ylocation) {}

}


