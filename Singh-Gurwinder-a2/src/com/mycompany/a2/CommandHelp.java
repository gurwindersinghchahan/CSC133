package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.table.TableLayout;

public class CommandHelp extends Command // tick command 
{
	private GameWorld gw;
	
	public CommandHelp(GameWorld gw)
	{
		super ("Help");
		this.gw = gw;
	}
	
	public void actionPerformed( ActionEvent e )// actionPerformed() would call clockTick() method in GameWorld
	{
		Dialog helpBox = new Dialog("Help", new TableLayout(10, 2));
		
		helpBox.add(new Label("Controls/ Command"));
		helpBox.add(new Label("to Accelerate, press a "));
		helpBox.add(new Label("to Brake, press b "));
		helpBox.add(new Label("to make left turn, press l"));
		helpBox.add(new Label("to make right turn,press r "));
		helpBox.add(new Label("to collide with energy station, press e"));
		helpBox.add(new Label("to collide with drone, press g"));
		helpBox.add(new Label("to tick the clock,press t"));
		helpBox.add(new Label("to exit, press x"));
		
		
		Command okCommand = new Command("ok");
		Command c = Dialog.show("", helpBox, okCommand);
		if (c == okCommand) {
			return;
}
	}
}
