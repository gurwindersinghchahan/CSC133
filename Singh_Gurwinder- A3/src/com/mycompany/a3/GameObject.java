package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;

public  class  GameObject 
{
	private int size = 0 ; //All game objects have an integer attribute size.
	private double xlocation = 0.0;// All games objects have location and intial location of objects is set to 0,0 for both x and y
	private double ylocation = 0.0;// "   "   "  " 
	private int color = 0;//All game objects have color defined as integer
	
	// Declartion of setter and getter methods
	
	public void setSize (int size)
	{
		this.size = size;
	}
	public int getSize() // All game objects can obtain the size but they cannot change the size. 
	{
		return size;
	}
	
	public void setXlocation (double xlocation,int mapHeight, int mapWidth)// All game objects have x and y location and intial location is at 0.0, and 0.0
	{
		if (xlocation > 0 && xlocation < mapWidth - this.size) {
			this.xlocation = xlocation;	
		} else if (xlocation > mapWidth - this.size ) {
			this.xlocation = (mapWidth - (this.size));
		} else if (xlocation < 0){
			this.xlocation = 0;
		}
	}
	public double getXlocation()
	{
		return xlocation;
	}
	public void setYlocation (double ylocation,int mapHeight, int mapWidth)// Intial location is set to zero because we want objects are at center in the world
	{
		if (ylocation > 0 && ylocation < mapHeight - (this.size )) {
			this.ylocation = ylocation;
		} else if (ylocation > mapHeight - (this.size )) {
			this.ylocation = mapHeight - (this.size );
		} else if (ylocation < 0) {
			this.ylocation = 0;
		}
	}
	public double getYlocation()
	{
		return ylocation;
	}
	public void setColor (int color)// All the game objects have color defined as integer 
	{
		this.color = color;
	}
	public int getColor()
	{
		return color;
	} 
	
	// Location and color can be changed however size does not have ability  to get changed once it is created. 
	public String toString() // Display method
	{
		String myDesc = " loc=" + Math.round(xlocation*10.0)/10.0 + "," + Math.round(ylocation*10.0)/10.0 + 
				" color=[" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]"  + 
				" size="  + this.getSize();
			
		return myDesc;
	}
	
}
