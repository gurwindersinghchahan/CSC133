package com.mycompany.a3;

import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;

import com.codename1.ui.Command;
public class CommandPosition extends Command {

	private GameWorld gw;

	public CommandPosition(GameWorld gw) 
	{
		super("Position");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent ev) {

		gw.setPositionable(true);
	}
	
	
}
