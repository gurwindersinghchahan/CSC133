package com.mycompany.a3;

import com.mycompany.a3.GameObject;

public abstract class FixedObject extends GameObject
{
	
	public FixedObject(double xlocation, double ylocation) //All fixed objects are not allowed are not allowed to change location once they are created
	{
		super.setXlocation(xlocation,1000000,1000000);
		super.setYlocation(ylocation,1000000,1000000);
	}
	
	/*public void setXlocation(double xlocation) {}// Making sure location cannot be changed
	public void setYlocation(double ylocation) {}
	*/
}


