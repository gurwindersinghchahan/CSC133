package com.mycompany.a3;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
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
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;

import java.io.IOException;
import java.io.InputStream;
import java.lang.String;

import com.codename1.charts.util.ColorUtil;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;

import com.codename1.ui.util.UITimer;
import com.codename1.ui.util.UITimer;

public class Game extends Form implements Runnable
{	
	//Declaration of varaibles
	private GameWorld gw;
	private ScoreView sv;
	private MapView mv;
	private int time =  1000;
	
	
	private Command accelerateCommand;
	private Command leftCommand;
	private Command brakeCommand; 
	private Command rightCommand;
	private Command exitCommand;
	private Command pauseCommand;
	private Command positionCommand;

	private Button accelerateButton;
	private Button accelerateMenuButton;
	private Button leftButton;
	private Button brakeButton; 
	private Button rightButton;
	private Button positionButton;
	private Button exitButton;
	private Button pauseButton;

	

	//private BGSound bgSound = new BGSound("background.mp3");
	
	public Game() 
	{
		gw = new GameWorld();
		sv = new ScoreView(gw);
		mv = new MapView(gw);
		
		//UITimer timer = new UITimer(this);
		//timer.schedule(1000, true, this);
		
		Toolbar toolbar = new Toolbar();
		this.setToolbar(toolbar);
		toolbar.setTitle("Robo-Track Game");
		
		this.setLayout(new BorderLayout());
		
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
		 accelerateCommand = new CommandAccelerate(gw);
		 brakeCommand = new CommandBrake(gw);
		 leftCommand = new CommandLeft(gw);
		 rightCommand = new CommandRight(gw);
		 pauseCommand = new CommandPause(gw);
		 positionCommand = new CommandPosition(gw);
		 exitCommand = new CommandExit(gw);
		
		
		// Key listerners which execute king binding mechanism 
		addKeyListener('a', accelerateCommand);
		addKeyListener('b', brakeCommand);
		addKeyListener('l', leftCommand);
		addKeyListener('r', rightCommand);
		//addKeyListener('e', eneryStationCollisionCommand);
		//addKeyListener('g', droneCollisionCommand);
		//addKeyListener('t', tickCommand);
		addKeyListener('x', exitCommand);

	
		accelerateButton = new Button("Accelerate");// Acclerate button creation
		accelerateButton.setCommand(accelerateCommand);
		westContainer.addComponent(accelerateButton);
		accelerateButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setMarginBottom(10); 
		
		accelerateMenuButton = new Button("Accelerate");// Acclerate button creation
		accelerateMenuButton.setCommand(accelerateCommand);
	
		leftButton = new Button("Left"); // Left button creation
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
		
		brakeButton = new Button("Brake");// Break button creation
		brakeButton.setCommand(brakeCommand);
		eastContainer.addComponent(brakeButton);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setBgTransparency(255);	
		brakeButton.getAllStyles().setMarginBottom(10);
		
		rightButton = new Button("Right");// Right button declaration
		rightButton.setCommand(rightCommand);
		eastContainer.addComponent(rightButton);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setBgTransparency(255);	
		rightButton.getAllStyles().setMarginBottom(10);
		
		pauseButton = new Button("Pause");// NPR button declaration
		southContainer.add(pauseButton);
		pauseButton.setCommand(pauseCommand);
		pauseButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		pauseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		pauseButton.getAllStyles().setBgTransparency(255);	
		pauseButton.getAllStyles().setMarginRight(5);
		
		positionButton = new Button("Position");// Base button collision creation
		southContainer.add(positionButton);
		positionButton.setCommand(positionCommand);
		positionButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		positionButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		positionButton.getAllStyles().setBgTransparency(255);	
		positionButton.getAllStyles().setMarginRight(5);
		positionButton.getDisabledStyle().setFgColor(ColorUtil.BLUE);
		positionButton.getDisabledStyle().setBgColor(ColorUtil.WHITE);
		
		
		toolbar.addComponentToSideMenu(accelerateMenuButton);
		Command soundCommand = new CommandSound(gw);
		CheckBox soundCheck = new CheckBox();
		toolbar.addComponentToSideMenu(soundCheck);
		soundCheck.setCommand(soundCommand);
		
		Command aboutInfoCommand = new CommandAbout(gw);
		toolbar.addCommandToSideMenu(aboutInfoCommand);
		Command helpButton = new CommandHelp(gw);
		toolbar.addCommandToRightBar(helpButton);

		toolbar.addCommandToSideMenu(exitCommand);
		
		//this.setLayout(new BorderLayout());
		this.add(BorderLayout.WEST, westContainer);
		this.add(BorderLayout.EAST, eastContainer);
		this.add(BorderLayout.SOUTH, southContainer);
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		this.show();
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());
		UITimer timer = new UITimer(this);
		timer.schedule(1000, true, this);
		gw.init();
	
	}
	public void run() {
	
		
		//gw.clockTick();
		
		if (!gw.getPaused()) 
		{
			gw.clockTick(time);
		}
		toggleCommand(gw.getPaused());
		if (!gw.getPaused()) 
		{
			playSounds();	
			pauseButton.setText("Pause");
		}
		if(gw.getPaused())
		{
			pauseButton.setText("Play");
			//bgSound.pause();
		}

		
	}
	
public void toggleCommand(boolean isPaused) {
		
		accelerateCommand.setEnabled(!isPaused);
		leftCommand.setEnabled(!isPaused);
		brakeCommand.setEnabled(!isPaused);
		rightCommand.setEnabled(!isPaused);
		positionCommand.setEnabled(isPaused);
		
		accelerateButton.setEnabled(!isPaused);
		accelerateMenuButton.setEnabled(!isPaused);
		leftButton.setEnabled(!isPaused);
		brakeButton.setEnabled(!isPaused);
		rightButton.setEnabled(!isPaused);
		positionButton.setEnabled(isPaused);

		if (isPaused) {
			
			removeKeyListener('a', accelerateCommand);
			removeKeyListener('b', brakeCommand);
			removeKeyListener('l', leftCommand);
			removeKeyListener('r', rightCommand);
			removeKeyListener('x', exitCommand);
			
		} else {
			
			addKeyListener('a', accelerateCommand);
			addKeyListener('b', brakeCommand);
			addKeyListener('l', leftCommand);
			addKeyListener('r', rightCommand);
			addKeyListener('x', exitCommand);
		}
		
	}
	
	
	//play the sounds
	public void playSounds() {
		
		if(gw.getSoundChecked()){
			if(gw.isDronesCollision()) {
				gw.setisDronesCollision(false);
				Sound dronessound = new Sound("electric.wav", "audio/wav");
				if (!gw.getPaused()) {
					dronessound.play();	
				}
				
			}
			if(gw.isEnergyStationsCollision()) {
				gw.setisEnergyStationsCollision(false);
				Sound energysound = new Sound("flycrash.wav", "audio/wav");
				if (!gw.getPaused()) {
					energysound.play();
				}
			}
			if(gw.isBasesCollision()) {
				gw.setisBasesCollision(false);
				Sound baseSound = new Sound("explosion.wav", "audio/wav");
				if (!gw.getPaused()) {
					baseSound.play();
				}
			}
			if (!gw.getPaused()) {
				//bgSound.play();
			} else {
				System.exit(0);
				//bgSound.pause();
			}
				
		}
	}
}


		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	