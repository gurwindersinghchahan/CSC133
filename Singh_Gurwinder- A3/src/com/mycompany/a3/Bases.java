package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
//import com.codename1.charts.models.Point;
import com.codename1.ui.Dialog;

//import java.util.Random;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Bases extends FixedObject implements IDrawable, ICollider, ISelectable 
// Bases is a concrete class of Fixed Object meaning their location is fixed  
{
	private int sequenceNumber = 1;// There are four bases and so it starts at 1
	private boolean isSelected = false;
	public Bases(double xlocation, double ylocation,int sequenceNumber)// constructor 
	
	{
		super(xlocation, ylocation);
		this.setColor(ColorUtil.GREEN);// setting the color of Bases
		this.setSize(125);// All the bases have same size 
		this.sequenceNumber= sequenceNumber;// setting the sequence number 
		
	}
	
	public int getSequenceNumber()// getter method for sequence number 
	{
		return sequenceNumber;
	}
	public void setColor(int color)
	{
		// color cannot be changed for bases
	}
	public String toString() // Display method
	{
		String parentDesc = super.toString();
		String myDesc = " seqNum=" + sequenceNumber;
		return "Base:" + parentDesc + myDesc;
		
	}
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.YELLOW);
		
		int x[] = new int[3];
		int y[] = new int[3];
		
		x[0] = (int)(pCmpRelPrnt.getX() + this.getXlocation() );
		x[1] = (int)(pCmpRelPrnt.getX() + this.getXlocation() + this.getSize());
		x[2] = (int)(pCmpRelPrnt.getX() + this.getXlocation() + (this.getSize() / 2));
		
		y[0] = (int)(pCmpRelPrnt.getY() + this.getYlocation() );
		y[1] = (int)(pCmpRelPrnt.getY() + this.getYlocation());
		y[2] = (int)(pCmpRelPrnt.getY() + this.getYlocation() + this.getSize() );
		if (isSelected()) {
			g.drawPolygon(x, y,3 );
			g.setColor(ColorUtil.YELLOW);
		} else {
			g.fillPolygon(x, y, 3);
			g.setColor(ColorUtil.BLACK);
		}


		g.drawString("" + getSequenceNumber(), (int)(pCmpRelPrnt.getX() + this.getXlocation() + this.getSize() / 2.5),  (int)(pCmpRelPrnt.getY() + this.getYlocation() + this.getSize() / 2.8 ));
		
	}

	//collide with
	public boolean collidesWith(ICollider otherObject) {
		
		return false;
	}

	//handle collision
	public void handleCollision(ICollider otherObject) 
	{
		
		
		
	}
	
	//set selected
	public void setSelected(boolean yesNo) {
		isSelected = yesNo;	
	}


	public boolean isSelected() {
		return isSelected;
	}

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

	
	
	
	
	

