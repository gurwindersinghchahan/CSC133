package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.codename1.ui.*;
import com.codename1.ui.table.TableLayout;

public class CommandAbout extends Command // Acclearte command 
{
	private GameWorld gw;
	
	public CommandAbout(GameWorld gw)
	{
		super ("About");
		this.gw = gw;
	}
	
	public void actionPerformed( ActionEvent e )
	{
		Dialog aboutBox = new Dialog("About", new TableLayout(4,1));
		
		Command okCommand = new Command("ok");
		
		aboutBox.add(new Label("Gurwinder Singh"));
		aboutBox.add(new Label("CSC 133"));
		aboutBox.add(new Label("Robo-Track  Game"));

		Command c = Dialog.show("", aboutBox, okCommand);
		if (c == okCommand) {
			return;
}
	}
}
