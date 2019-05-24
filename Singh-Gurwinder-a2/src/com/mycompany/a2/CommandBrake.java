package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandBrake extends Command // Brake command 
{
	private GameWorld gw;
	
	public CommandBrake(GameWorld gw)
	{
		super ("Brake");
		this.gw = gw;
	}
	
	public void actionPerformed( ActionEvent e)// actionPerformed() would call brake() method in GameWorld
	{
		gw.brake();
	}
}
