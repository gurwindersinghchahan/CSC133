package com.mycompany.a2;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;



public class Game extends Form
{	
	//Declaration of varaibles
	private GameWorld gw;
	private ScoreView sv;
	private MapView mv;
	//private boolean isQuit = false;
	
	public Game() 
	{
		gw = new GameWorld();
		sv = new ScoreView(gw);
		mv = new MapView(gw);
		
		
		
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("Robo-Track Game");
		
		// Creating West Container
		Container westContainer = new Container();
		westContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		westContainer.setLayout(new BoxLayout(2));
		// Creating East Container
		Container eastContainer = new Container();
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		eastContainer.setLayout(new BoxLayout(2));
		// Creating South Container
		Container southContainer = new Container();
		southContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		southContainer.setLayout(new FlowLayout(Component.CENTER));
		
		// Commands
		Command accelerateCommand = new CommandAccelerate(gw);
		Command brakeCommand = new CommandBrake(gw);
		Command leftCommand = new CommandLeft(gw);
		Command rightCommand = new CommandRight(gw);
		Command eneryStationCollisionCommand = new CommandEnergyStationCollision(gw);
		Command droneCollisionCommand = new CommandDroneCollision(gw);
		Command tickCommand = new CommandGameClockTick(gw);
		Command exitCommand = new CommandExit(gw);
		
		Command baseCommand = new CommmandBaseCollision(gw);
		Command nprCommand = new CommandNonPlayerRobotCollision(gw);
		
		// Key listerners which execute king binding mechanism 
		addKeyListener('a', accelerateCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('l', leftCommand);
		addKeyListener('r', rightCommand);
		addKeyListener('e', eneryStationCollisionCommand);
		addKeyListener('g', droneCollisionCommand);
		addKeyListener('t', tickCommand);
		addKeyListener('x', exitCommand);

	
		Button accelerateButton = new Button("Accelerate");// Acclerate button creation
		accelerateButton.setCommand(accelerateCommand);
		westContainer.addComponent(accelerateButton);
		accelerateButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setMarginBottom(10); 
		
	
		Button leftButton = new Button("Left"); // Left button creation
		leftButton.setCommand(leftCommand);
		westContainer.addComponent(leftButton);	
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setBgTransparency(255);	
		leftButton.getAllStyles().setMarginBottom(10);
		
		Button changeStategy = new Button("Change Startgies"); //Change Startgies
		westContainer.addComponent(changeStategy);	
		changeStategy.getAllStyles().setFgColor(ColorUtil.WHITE);
		changeStategy.getAllStyles().setBgColor(ColorUtil.BLUE);
		changeStategy.getAllStyles().setBgTransparency(255);	
		changeStategy.getAllStyles().setMarginBottom(10);
		
		Button brakeButton = new Button("Brake");// Break button creation
		brakeButton.setCommand(brakeCommand);
		eastContainer.addComponent(brakeButton);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setBgTransparency(255);	
		brakeButton.getAllStyles().setMarginBottom(10);
		
		Button rightButton = new Button("Right");// Right button declaration
		rightButton.setCommand(rightCommand);
		eastContainer.addComponent(rightButton);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setBgTransparency(255);	
		rightButton.getAllStyles().setMarginBottom(10);
		
		Button nprButton = new Button("Collide with NPR");// NPR button declaration
		southContainer.add(nprButton);
		nprButton.setCommand(nprCommand);
		nprButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		nprButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		nprButton.getAllStyles().setBgTransparency(255);	
		nprButton.getAllStyles().setMarginRight(5);
		
		Button baseButton = new Button("Collide with Base");// Base button collision creation
		southContainer.add(baseButton);
		baseButton.setCommand(baseCommand);
		baseButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		baseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		baseButton.getAllStyles().setBgTransparency(255);	
		baseButton.getAllStyles().setMarginRight(5);
		
		Button energyButton = new Button("Collide with Energy Station");// Energy Station button collision
		southContainer.add(energyButton);
		energyButton.setCommand(eneryStationCollisionCommand);
		energyButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		energyButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		energyButton.getAllStyles().setBgTransparency(255);	
		energyButton.getAllStyles().setMarginRight(5);
		
		Button droneButton = new Button("Collide with Drone");// drone collision button creation
		southContainer.addComponent(droneButton);
		droneButton.setCommand(droneCollisionCommand);
		droneButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		droneButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		droneButton.getAllStyles().setBgTransparency(255);	
		droneButton.getAllStyles().setMarginRight(5);
		
		Button tickButton  = new Button("Tick");// tick command button creation
		tickButton.setCommand(tickCommand);
		southContainer.add(tickButton);
		tickButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setBgTransparency(255);	
		tickButton.getAllStyles().setMarginRight(5);
		
		toolbar.addCommandToSideMenu(accelerateCommand);
		Command soundCommand = new CommandSound(gw);
		CheckBox soundCheck = new CheckBox();
		toolbar.addComponentToSideMenu(soundCheck);
		soundCheck.setCommand(soundCommand);
		
		Command aboutInfoCommand = new CommandAbout(gw);
		toolbar.addCommandToSideMenu(aboutInfoCommand);
		Command helpButton = new CommandHelp(gw);
		toolbar.addCommandToRightBar(helpButton);

		toolbar.addCommandToSideMenu(exitCommand);
		
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.WEST, westContainer);
		this.add(BorderLayout.EAST, eastContainer);
		this.add(BorderLayout.SOUTH, southContainer);
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());
		
		gw.init();
		this.show();
	}
}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	