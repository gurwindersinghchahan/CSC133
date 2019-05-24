package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;
import com.codename1.ui.*;

public class CommandExit extends Command // Exit command 
{
	private GameWorld gw;
	
	public CommandExit(GameWorld gw)
	{
		super ("Exit");
		this.gw = gw;
	}
	
	public void actionPerformed( ActionEvent e )// actionPerformed() would call exit() method in GameWorld
	{
		Command yes = new Command("Yes");
		Command  no  = new Command("No");
		
		Label labelone = new Label("");
		
		Command c = Dialog.show("Are you sure you want to exit", labelone, yes, no);
		
		if(c == yes) 
		{
			gw.exit();
		}
		else if (c == no) 
		{
			return;
		}
	}
}
