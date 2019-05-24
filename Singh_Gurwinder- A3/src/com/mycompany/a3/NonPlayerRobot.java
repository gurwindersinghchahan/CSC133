package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;


public class NonPlayerRobot extends Robots  implements IDrawable,ICollider {
	
	public NonPlayerRobot(double xlocation, double ylocation)//Constructor
	{
		super(xlocation, ylocation);
		this.setXlocation(xlocation,100000,100000);
		this.setYlocation(ylocation,100000,100000);
		this.setSize(50);
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

	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.GRAY);
		//g.fillArc((int)(pCmpRelPrnt.getX()+this.getXlocation()), (int)(pCmpRelPrnt.getY()+this.getYlocation()), this.getSize(), this.getSize(), 0, 360);
		g.drawRect((int)(pCmpRelPrnt.getX()+this.getXlocation()), (int)(pCmpRelPrnt.getY()+this.getYlocation()), this.getSize(), this.getSize());
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
		// TODO Auto-generated method stub
	
	
}
}
		
