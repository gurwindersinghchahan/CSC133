package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
public class Game extends Form
{	
	//Declaration of varaibles
	private GameWorld gw;
	private boolean isQuit = false;
	
	public Game() 
	{
		gw = new GameWorld();
		gw.init();
		play();
	}
	private void play()
	{
		
		Label myLabel=new Label("Enter a Command:");// User input of commands
		this.addComponent(myLabel);
		final TextField myTextField= new TextField();
		this.addComponent(myTextField);
		this.show();
	
	myTextField.addActionListener(new ActionListener()
	{
	
		public void actionPerformed(ActionEvent evt) {
		
		String sCommand=myTextField.getText().toString();
		myTextField.clear();
		
		if(isQuit== true) // checking if user wants to quit
		{						
			switch(sCommand.charAt(0))
			{
				case 'y' : 
					System.exit(0); 
					break;
				case'n' :
					isQuit = false;
					break;
				default:
					System.out.println("Enter a valid command");
			}
			return;
		}
		switch (sCommand.charAt(0))
			{
			case 'a':	
				gw.accelerate();
				break;
			case 'b':	
				gw.brake();
				break;
			case 'l':	
				gw.left();
				break;
			case 'r':	
				gw.right();
				break;
			case'c':
				gw.robotsCollision();
				break;
			case '1':	
				gw.baseCollision(1);
				break;
			case '2':	
				gw.baseCollision(2);
				break;
			case '3':	
				gw.baseCollision(3);
				break;
			case '4':	
				gw.baseCollision(4);
				break;
			case '5':	
				gw.baseCollision(5);
				break;
			case '6':	
				gw.baseCollision(6);
				break;
			case '7':	
				gw.baseCollision(7);
				break;
			case '8':	
				gw.baseCollision(8);
				break;
			case '9':	
				gw.baseCollision(9);
				break;
			case 'e':	
				gw.energyStationsCollision();
				break;
			case 'g':	
				gw.dronesCollision();
				break;
			case 't':
				gw.clockTick();
				break;
			case 'd':	
				gw.display();
				break;
			case 'm':	
				gw.map();
				break;
			case 'x':	
				System.out.println("Do you want to quit this game? 'Y' or 'N'");
				isQuit = true;
				break;
			default :	
				System.out.println("Invalid Keyboard Input");

			}
		  }		
});
}
}	
	

	
	
		
		
		
		
		
		
		

