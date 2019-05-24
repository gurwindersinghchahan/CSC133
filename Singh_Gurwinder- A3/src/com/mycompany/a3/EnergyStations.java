package com.mycompany.a3;

import com.codename1.ui.geom.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

import com.codename1.charts.util.ColorUtil;
// Energy stations is a concret class of Fixed object class
public class EnergyStations extends FixedObject implements IDrawable, ICollider, ISelectable {
	
	
	private int capacity  ;// Energy stations have an attribute called capacity
	private boolean isSelected;
	public EnergyStations (double xlocation, double ylocation, int size)// Constructor
	{
		super(xlocation, ylocation);// location is obtain from parent class that cannot be change
		this.setColor(ColorUtil.MAGENTA);
		this.setSize(65);
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
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.MAGENTA);
		
		if (isSelected()) {
			
			g.drawArc((int)(pCmpRelPrnt.getX()+this.getXlocation())
            		, (int)(pCmpRelPrnt.getY()+this.getYlocation())
            		, this.getSize(), getSize(), 0, 360);
			g.setColor(this.getColor());
			
		} else {
			g.fillArc((int)(pCmpRelPrnt.getX()+this.getXlocation())
	        		, (int)(pCmpRelPrnt.getY()+this.getYlocation())
	        		, this.getSize(), getSize(), 0, 360);
			
			
			
			g.setColor(ColorUtil.BLACK);
		}
		g.drawString("" + getCapacity(), (int)(pCmpRelPrnt.getX() + this.getXlocation() ),  (int)(pCmpRelPrnt.getY() + this.getYlocation()  ));
		
	}

	//to collide with something
	public boolean collidesWith(ICollider otherObject) {
		
		return false;
	}

	//to handle the collision
	public void handleCollision(ICollider otherObject) {
	
		
	}
	
	//setter for the isselected
	public void setSelected(boolean yesNo) {
		isSelected = yesNo;	
	}

	//getter for issleceted
	public boolean isSelected() {
		return isSelected;
	}

	//check if contains
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = pPtrRelPrnt.getX(); // pointer location relative to
		int py = pPtrRelPrnt.getY(); // parent’s origin
		int xLoc = (int) (pCmpRelPrnt.getX()+ this.getXlocation());// shape location relative 
		int yLoc = (int) (pCmpRelPrnt.getY()+ this.getYlocation());// to parent’s origin
		if ( (px >= xLoc) && (px <= xLoc+this.getSize())&& (py >= yLoc) && (py <= yLoc+this.getSize()) )
		        return true; 
		else
		        	return false;
		
	}
	
	
	
}
