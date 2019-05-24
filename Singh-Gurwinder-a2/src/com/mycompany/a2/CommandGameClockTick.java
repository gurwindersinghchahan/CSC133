package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandGameClockTick extends Command // tick command 
{
	private GameWorld gw;
	
	public CommandGameClockTick(GameWorld gw)
	{
		super ("Tick");
		this.gw = gw;
	}
	
	public void actionPerformed( ActionEvent e )// actionPerformed() would call clockTick() method in GameWorld
	{
		gw.clockTick();
	}
}
