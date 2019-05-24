package com.mycompany.a3;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;


public class CommandPause extends Command {

	private GameWorld gw;

	public CommandPause(GameWorld gw) 
	{
		super("Pause");
		this.gw = gw;	
	}
	public void actionPerformed(ActionEvent ev) {

		gw.togglePaused();
	}
	
	
}