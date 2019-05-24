package com.mycompany.a3;
import java.util.Random;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import com.codename1.charts.util.ColorUtil;

public class Drones extends MovableObject implements IDrawable, ICollider {
	
	Random rand = new Random();
	
	//Constructor
	public Drones (double xLocation, double yLocation,int speed, int size, int heading)
	{
		super(heading);
		this.setXlocation(xLocation,100000,100000);
		this.setYlocation(yLocation,100000,100000);
		super.setSize(90);
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
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(this.getColor());
		
		int x[] = new int[3];
		int y[] = new int[3];
		
		x[0] = (int)(pCmpRelPrnt.getX() + this.getXlocation() );
		x[1] = (int)(pCmpRelPrnt.getX() + this.getXlocation() + this.getSize());
		x[2] = (int)(pCmpRelPrnt.getX() + this.getXlocation() + (this.getSize() / 2));
		
		y[0] = (int)(pCmpRelPrnt.getY() + this.getYlocation() );
		y[1] = (int)(pCmpRelPrnt.getY() + this.getYlocation());
		y[2] = (int)(pCmpRelPrnt.getY() + this.getYlocation() + this.getSize() );
		
		g.drawPolygon(x, y, 3);
	}

	public boolean collidesWith(ICollider otherObject) {
		boolean result = false;
		int thisCenterX = (int) (this.getXlocation() + (this.getSize()/2)); // find centers 
		int thisCenterY = (int) (this.getYlocation() + (this.getSize()/2));
		int otherCenterX = (int) (((GameObject) otherObject).getXlocation() + (((GameObject)otherObject).getSize()/2));
		int otherCenterY = (int) (((GameObject)otherObject).getYlocation() + (((GameObject)otherObject).getSize()/2));
		// find dist between centers (use square, to avoid taking roots)
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int distBetweenCentersSqr = (dx*dx + dy*dy);
		     // find square of sum of radii
		int thisRadius = this.getSize()/2;
		int otherRadius = ((GameObject)otherObject).getSize()/2;
		int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius
		+ otherRadius*otherRadius); if (distBetweenCentersSqr <= radiiSqr) { result = true ; }
		  return result ;
	}

	public void handleCollision(ICollider otherObject) {
		
	}
	

}
