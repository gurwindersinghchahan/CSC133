package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandAccelerate extends Command // Acclearte command 
{
	private GameWorld gw;
	
	public CommandAccelerate(GameWorld gw)
	{
		super ("Accelerate");
		this.gw = gw;
	}
	
	public void actionPerformed( ActionEvent e )// actionPerformed() would call accelerate() method in GameWorld
	{
		gw.accelerate();
	}
}
