package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class CommandDroneCollision extends Command // drone collision command 
{
	private GameWorld gw;
	
	public CommandDroneCollision(GameWorld gw)
	{
		super ("Collide With Drone");
		this.gw = gw;
	}
	
	public void actionPerformed( ActionEvent e )// actionPerformed() would call dronecollision() method in GameWorld
	{
		gw.dronesCollision();
	}
}
