package com.mycompany.a3;
//import java.util.ArrayList;

import java.util.Random;
import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;
import com.codename1.charts.util.ColorUtil;

import java.util.ArrayList;
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
	private boolean isPaused = false;
	private GameObjectCollection list;
	private boolean isPositionable = false;
	private boolean DronesCollide = false;
	private boolean BasesCollide = false;
	private boolean energystationsCollide = false;
	
	private ArrayList<GameObject> colliderList = new ArrayList<GameObject>();
	private int mapHeight;
	private int mapWidth;
	
	
	
	
	public GameWorld()
	{
		list = new GameObjectCollection();
		robots = new PlayerRobot(25.0, 25.0);
		//nprrobots = new NonPlayerRobot(500.0,475.0 );
	}
	
	
	public void init() 
	{
		list = new GameObjectCollection();
		//list.clear();
		robots.reset();
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
		list.add(new Bases(100.0 ,300.0,1));//  Creating Bases, and all bases should be assigned to locations chosen by user.
		list.add(new Bases(400.00,180.0,2));
		list.add(new Bases(890.0,200.0,3));
		list.add(new Bases(900.0,700.0,4));
	}
	public void addRobots()
	{
		list.add(robots);
	}
	public void addNonPlayerRobot()
	{
		list.add(new NonPlayerRobot(555.0, 444.0));
		list.add(new NonPlayerRobot(235.0, 450.0));
		list.add(new NonPlayerRobot(400.0, 600.0));
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
		int speedDecrease  = -2;
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
		System.out.println("NPR robots has been collided");		
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
	public void energyStationsCollision(EnergyStations energyStation)// This method execute the commands when user pretend that robots has been collided with base station
	{
		// increase the ladybug food 
				robots.setEnergyLevel(robots.getEnergyLevel() + ((EnergyStations) energyStation).getCapacity());
				// create a new food station in random size and location
				if (((EnergyStations)energyStation).getCapacity() !=0) {
					list.add(new EnergyStations(randomX(), randomY(), randomSize()));		
				}

				// set the food station food to zero
				((EnergyStations) energyStation).setCapacity(0);
				// change color to light green
				((EnergyStations) energyStation).setColor(ColorUtil.rgb(0, 120, 0));

				
				this.setChanged();
				this.notifyObservers();
	}
			
	
	public void dronesCollision()// This method execute the commands after the collision of drones
	{
		robots.collisionOfDrones();
		this.setChanged();
		this.notifyObservers();
		System.out.println("Robot and Drone have collided");	
	}
	public void clockTick(int time) {
		
		
		IIterator theElements = list.getIterator();
		while ( theElements.hasNext() ) {
			GameObject f = (GameObject) theElements.getNext();
			if (f instanceof Drones) 
			{
				((Drones) f).randomHeading();
				
			}
			if (f instanceof MovableObject) 
			{
				((MovableObject) f).move(time, mapHeight,mapWidth);
			}

		}
		IIterator theColliders = list.getIterator();
		while(theColliders.hasNext()){
			ICollider curObj = (ICollider)theColliders.getNext(); // get a collidable object // check if this object collides with any OTHER object
			if (robots.collidesWith(curObj)) {
				
				if (!colliderList.contains((GameObject)curObj)) {
					colliderList.add((GameObject) curObj);
					if (curObj instanceof Drones) {
						dronesCollision();
						DronesCollide = true;
					}
					if (curObj instanceof EnergyStations) {
						energyStationsCollision((EnergyStations)curObj);
						energystationsCollide = true;
					}
					if (curObj instanceof Bases) {
						baseCollision(((Bases) curObj).getSequenceNumber());
						BasesCollide = true;
					}
					
				}
			} 
			else 
			{
				colliderList.remove((GameObject) curObj);
				
			}
		}
		
		
		robots.reduceEnergy();// Robots energy level is reduced by the amount indicated by its energyConsumptionRate
		robots.setSteeringDirection(robots.getSteeringDirection()+ robots.getHeading());
		
		clock++;
		
		if(robots.getLastBasereached()== lastBase)	
		{
			System.out.println("Game Over, You win! Total time: " + this.clock);
			exit();
		}
		
			if (robots.getIsDead()) 
			{
				lives = lives - 1;
				if (lives == 0) 
				{
					System.out.println("Game Over, you failed");
					//robots = null;
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
		public boolean getSoundChecked() {
			return this.soundChecked;
		}
		public boolean isDronesCollision() {
			return DronesCollide;
		}
		public void setisDronesCollision(boolean d) {
			DronesCollide = d;
		}
		
		public boolean isBasesCollision() {
			return BasesCollide;
		}
		
		public void setisBasesCollision(boolean b) {
			BasesCollide = b;
		}
		
		public boolean isEnergyStationsCollision() {
			return energystationsCollide;
		}
		public void setisEnergyStationsCollision(boolean e) {
			energystationsCollide = e;
		}
		
		public void toggleSound()
		{
			this.soundChecked = !(this.soundChecked);
			this.setChanged();
			this.notifyObservers();
		}
		public void togglePaused () 
		{
			isPaused = !isPaused;
			isPositionable = false; 
		}
		public boolean getIsPositionable() {
			return isPositionable;
		}
		
		public void setPositionable(boolean b) {
			isPositionable = b;
		}

		 public boolean getPaused() {
			
			return isPaused;
		}
		
		
		public void showMap()
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
		public GameObjectCollection getGameObjectCollection () {
			return list;
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
		public void draw(Graphics g, Point pCmpRelPrnt) {
			IIterator theElements = list.getIterator();
			while(theElements.hasNext()) {
				IDrawable dobj = (IDrawable)theElements.getNext();
				dobj.draw(g, pCmpRelPrnt);
			}
		}
		public void exit()
		{
			System.exit(0);
		}
		
		
		
}

	
	
	
	
	
	
	

