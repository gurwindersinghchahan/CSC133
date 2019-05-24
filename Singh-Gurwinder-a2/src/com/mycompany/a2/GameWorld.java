package com.mycompany.a2;
//import java.util.ArrayList;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import java.util.Observable;

public class GameWorld extends Observable{// Game world is defined as an observable
	
	private int lives = 3; 
	private int clock =0;
	//private ArrayList<GameObject> list  = new ArrayList<GameObject>(); // Array list to store Game Object 
	//Robots robots = new Robots(0.0,0.0);
	private PlayerRobot robots;
	private NonPlayerRobot nprrobots;
	Random rand = new Random();
	private int lastBase = 4;
	private boolean soundChecked = false;
	private GameObjectCollection list;
	private int mapHeight;
	private int mapWidth;
	public GameWorld()
	{
		list = new GameObjectCollection();
		robots = new PlayerRobot(0.0, 0.0);
		nprrobots = new NonPlayerRobot(25.0,35.0);
	}
	
	
	public void init() 
	{
		//list = new GameObjectCollection();
		//list.clear();
		//robots.reset();
		addBases();// Calling the base to add four Bases to the Game World
		addRobots();// Adding the robots to game world
		addEnergyStations();//Adding the EnergyStations to the game world
		addEnergyStations();
		addDrones();
		addDrones();// Adding the Drones to the game World
		addNonPlayerRobot();
		this.setChanged();
		this.notifyObservers();
	}
	
	
	public void addBases()
	{
		list.add(new Bases(20.0,30.0,1));//  Creating Bases, and all bases should be assigned to locations chosen by user.
		list.add(new Bases(155.0,180.0,2));
		list.add(new Bases(235.0,200.0,3));
		list.add(new Bases(350.0,450.0,4));
	}
	public void addRobots()
	{
		list.add(robots);
	}
	public void addNonPlayerRobot()
	{
		list.add(nprrobots);
		list.add(nprrobots);
		list.add(nprrobots);
	}
	public void addEnergyStations()
	{
		list. add(new EnergyStations (randomX(), randomY(), randomSize()));
	}
	public void addDrones()
	{
		list. add(new Drones (randomX(), randomY(), randomSpeed(), randomSize(), randomHeading()));
	}
	
	public double randomX()// Generating the random number between 0 and 1024
	{
		int randomNum =  rand.nextInt((1024- 0) + 1)  + 0;
		return randomNum;
	}
	public double randomY()// Generating the random number between 0 and 768
	{
		int randomNum =  rand.nextInt((768-0) + 1)  + 0;
		return randomNum;
	}
	public int randomSize()// Generating the random number between 10 and 50
	{
		int randomNum =  rand.nextInt((50- 10) + 1)  + 10;
		return randomNum;
	}
	public int randomSpeed()// Generating the random number between 5 and 10
	{
		int randomNum =  rand.nextInt((10 - 5) + 1)  + 5 ;
		return randomNum;
	}
	public int randomHeading()// Generating the random number between 0 and 359
	{
		int randomNum =  rand.nextInt((359- 0) + 1)  + 0;
		return randomNum;
	}
	public void accelerate() // This method increase the speed player robots
	{
		int speedIncrease  = 2;
		robots.setRobotsSpeed(robots.getSpeed() + speedIncrease);
		this.setChanged();
		this.notifyObservers();
		System.out.println("The speed has been increased by 2 successfully");
	}
	public void brake()// This method decrease the speed of robot
	{
		int speedDecrease  = 2;
		robots.setRobotsSpeed(robots.getSpeed() - speedDecrease);
		this.setChanged();
		this.notifyObservers();
		System.out.println("The speed has been Decrease by 2 successfully");
	}
	public void left ()// This method turns the robot left
	{
		int leftChange = -5;
		robots.steeringHeading(leftChange);
		this.setChanged();
		this.notifyObservers();
		System.out.println("Robot has been turned left successfully");		
		
	}
	
	public void right ()// This method turns the robot right
	{
		int rightChange = 5;
		robots.steeringHeading(rightChange);
		this.setChanged();
		this.notifyObservers();
		System.out.println("Robot has been turned right successfully");		
	}
	public void robotsCollision()// This method shows that two robots have collided
	{
		robots.collisionOfRobots();
		this.setChanged();
		this.notifyObservers();
		System.out.println("Two Robots have collided");		
	}
	public void nprCollision()// This method shows that two robots have collided
	{
		nprrobots.NprCollisionWithRobot();
		this.setChanged();
		this.notifyObservers();
		System.out.println("NPR car has been collided");		
	}
	
	
	
	public void baseCollision(int x)// This method anytime user enter # between 1-9 we run the functions after robot has been collided with Base
	{
		System.out.println("Colliding with Base " + x );
		if ((x - robots.getLastBasereached()== 1))
		{
			robots.setLastBaseReached(x);
		
		}
		this.setChanged();
		this.notifyObservers();
	}
	public void energyStationsCollision()// This method execute the commands when user pretend that robots has been collided with base station
	{
			GameObject energyStation = new GameObject();	
			IIterator theElements = list.getIterator();
			while ( theElements.hasNext() ) 
			{
				GameObject f = (GameObject) theElements.getNext();
				{
				  if (f instanceof EnergyStations)
				  {
					if(((EnergyStations) f).getCapacity() != 0)
					{
						energyStation = f;
					}
				}
			}
			}
			// After the collision, Robots energy level is increased, capactiy is set to 0 and color is changed to light green
			robots.setEnergyLevel(robots.getEnergyLevel() + ((EnergyStations) energyStation).getCapacity());
			((EnergyStations) energyStation).setCapacity(0);
			((EnergyStations) energyStation).setColor(ColorUtil.rgb(0, 120, 0));
			list.add(new EnergyStations(randomX(), randomY(), randomSize()));
			this.setChanged();
			this.notifyObservers();
			System.out.println(" Robot have collided with Energy Station");	
	}
	public void dronesCollision()// This method execute the commands after the collision of drones
	{
		robots.collisionOfDrones();
		this.setChanged();
		this.notifyObservers();
		System.out.println("Robot and Drone have collided");	
	}
	public void clockTick() {
		
		clock++;
		IIterator theElements = list.getIterator();
		while ( theElements.hasNext() ) {
			GameObject f = (GameObject) theElements.getNext();
			if (f instanceof Drones) 
			{
				((Drones) f).randomHeading();
			}
			if (f instanceof MovableObject) 
			{
				((MovableObject) f).move();
			}

		}

		robots.reduceEnergy();// Robots energy level is reduced by the amount indicated by its energyConsumptionRate
			
		
		if(robots.getLastBasereached()== lastBase)	
		{
			System.out.println("Game Over, You win! Total time: " + this.clock);
		}
		if(nprrobots.getLastBasereached()== lastBase)	
		{
			System.out.println("Game Over, a non-player robot wins! Total time: " + this.clock);
		}
		
			if (robots.getIsDead()) 
			{
				lives = lives - 1;
				if (lives == 0) 
				{
					System.out.println("Game Over, you failed");
					System.exit(0);
				}
				else 
					System.out.print("Robot has died");
					this.init();
			
			}	
			this.setChanged();
			this.notifyObservers();
		System.out.println(" Clock has been ticked successfully");
		}
		public void display()
		{
			System.out.println("\nNumber of lives left is: " + lives );
			System.out.println("Current value of clock is: " + clock);
			System.out.println("The highest base number reached is: " + robots.getLastBasereached());
			System.out.println("Energy level of Robot is: " +  robots.getEnergyLevel());
			System.out.println("Robots Current Damage level is: " +  robots.getDamageLevel());
			
		}
		
		public String isSound()// sound function which is invoked from the side menu
		{
			if (this.soundChecked) {
				return " ON";
			} else {
				return " OFF";
			}

		}
	
		public void toggleSound()
		{
			this.soundChecked = !(this.soundChecked);
			this.setChanged();
			this.notifyObservers();
		}
		
		
		public void map()
		{
			System.out.println();
			IIterator theElements = list.getIterator();
			while ( theElements.hasNext() ) {
				GameObject g = (GameObject) theElements.getNext();
				System.out.println(g.toString());
			}
		}
		public int getLivesLeft()
		{
			return lives;
		}
		public int getClock()
		{
			return clock;
		}
		public int getRobotLastBaseReached()
		{
			return robots.getLastBasereached();
		}
		public int getEnergyLevel()
		{
			return robots.getEnergyLevel();
		}
		public int getDamageLevel()
		{
			return robots.getDamageLevel();
		}
		public void setMapHeight(int height)
		{
			this.mapHeight= height;
			System.out.println(""+ height);
		}
		public void setMapWidth(int width)
		{
			this.mapWidth= width;
			
		}
		
		public void exit()
		{
			System.exit(0);
		}
		
		
		
}

	
	
	
	
	
	
	

