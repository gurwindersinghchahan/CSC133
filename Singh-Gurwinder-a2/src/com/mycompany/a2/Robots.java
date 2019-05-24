package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;

public abstract class Robots extends MovableObject implements ISteerable// Robots implement Isterrable
{
	private int steeringDirection = 5;
	private int maximumSpeed = 35;
	private int energyLevel = 20;
	private int energyConsumptionRate = 4;
	private int damageLevel = 0;
	private int lastBaseReached = 1;
	private boolean isDead =  false; 
	
	public Robots (double xlocation, double ylocation)//Constructor
	{
		super(0);
		this.setXlocation(xlocation);
		this.setYlocation(ylocation);
		this.setSize(40);
		this.setSpeed(0);
		this.setColor(ColorUtil.MAGENTA);
		
	}
	public void steeringHeading (int updatedheading)// Updating the robot direction
	{
		this.setHeading(this.getHeading()+ updatedheading );
	}
	
	public void setRobotsSpeed(int speed)//Checker to make sure speed is less than maximum speed
	{
		if (speed < this.maximumSpeed )
		{
			this.speed = speed;
		}
		else 
		{
			System.out.println ("Speed is beyond maximum Speed, Not acceptable");
		}
		if (this.getSpeed() < 0 )
		{
			this.setSpeed(0);
		}
		
	}

	//Getter and Setter methods for attributes defined above
	
	public void setSteeringDirection(int steeringDirection)
	{
		
		this.steeringDirection = steeringDirection;
	}
	public int getSteeringDirection()
	{
		return steeringDirection;
	}
		
	public void setMaximumSpeed(int maximumSpeed)
	{
		
		this.maximumSpeed = maximumSpeed;
	}
	public int getMaximumSpeed ()
	{
		return maximumSpeed;
	}
	
	public void setEnergyLevel(int energyLevel)
	{
		
		this.energyLevel = energyLevel;
	}
	public int getEnergyLevel()
	{
		return energyLevel;
	}
	
	public void setEnergyConsumptionRate(int energyConsumptionRate)
	{
		
		this.energyConsumptionRate = energyConsumptionRate;
	}
	public int getEnergyConsumptionRate()
	{
		return energyConsumptionRate;
	}
	public void setDamageLevel(int damageLevel)
	{
		
		this.damageLevel = damageLevel;
	}
	public int getDamageLevel()
	{
		return damageLevel;
	}
	
	public void setLastBaseReached(int lastBaseReached)
	{
		
		this.lastBaseReached = lastBaseReached;
	}
	public int getLastBasereached()
	{
		return lastBaseReached;
	}
	
	public void checkDamageLevel()// setting the speed based on damagelevel
	{
		if (this.getDamageLevel() >=100 )
		{
			this.setSpeed(0);
		}
		if (this.getEnergyLevel() == 0)
		{
			this.setSpeed(0);
		}
		if (this.getSpeed() == 0)
		{
			this.isDead= true;
		}
	}
	public boolean getIsDead()
	{
		return isDead;
	}
	public void setIsDead(boolean isDead)
	{
		this.isDead = isDead;
	}
	
	public void collisionOfRobots()// This method execuate the c command to show two robots have been collided
	{
		this.damageLevel = (damageLevel + 15) ;		
		this.setColor(ColorUtil.rgb(255 - (20 *(10 - this.getDamageLevel())) , 0, 0));		
		this.updateRobotsSpeed();
	
	}
	public void collisionOfDrones()// This method execute the functions after robot has been collided with drones
	{
		this.damageLevel = (damageLevel + 15) ;		
		this.setColor(ColorUtil.rgb(255 - (20 *(10 - this.getDamageLevel())) , 0, 0));		
		this.updateRobotsSpeed();
	}
	
	
	public void updateRobotsSpeed()//Updating the speed 
	{
		
		if(this.getSpeed() < this.getMaximumSpeed() * this.getDamageLevel())
		{
			
		}
		else
		{
			this.setSpeed(this.getMaximumSpeed() * (this.getDamageLevel()/2));
		}
		this.checkDamageLevel();
	}
	public void reduceEnergy() 
	{
		energyLevel = energyLevel - energyConsumptionRate;
		if(energyLevel <= 0)
		{
			this.setRobotsSpeed(0);
			checkDamageLevel();
		}
	}
	public void reset() // Resetting the Robot after each live is lost
	{
		this.setColor(ColorUtil.MAGENTA);
		this.setHeading(0);
		this.setSpeed(1);
		this.setLastBaseReached(1);
		this.setXlocation(0);
		this.setYlocation(0);
		this.setEnergyLevel(20);
		this.setIsDead(false);
		this.setDamageLevel(0);
	}
	public String toString() // Display method
	{
		String parentDesc = super.toString();
		String myDesc = " maxSpeed=" + maximumSpeed + " steeringDirection=" + getSteeringDirection() + 
						" energyLevel=" + energyLevel  + " damageLevel=" + damageLevel;
		return  parentDesc + myDesc;
		
	}
	
}
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



