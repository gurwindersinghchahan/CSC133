package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
//import java.util.Random;

public class Bases  extends FixedObject
// Bases is a concrete class of Fixed Object meaning their location is fixed  
{
	private int sequenceNumber = 1;// There are four bases and so it starts at 1
	
	public Bases(double xlocation, double ylocation,int sequenceNumber)// constructor 
	
	{
		super(xlocation, ylocation);
		this.setColor(ColorUtil.BLUE);// setting the color of Bases
		this.setSize(15);// All the bases have same size 
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
	
	
	
	
}
