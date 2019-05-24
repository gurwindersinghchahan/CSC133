package com.mycompany.a3;

import java.util.*;
import java.util.Observer;
import java.util.Observable;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer
{
private GameWorld model;
	
	//labels declaration
	private Label livesLabel;
	private Label livesValue;
	private Label clockLabel;
	private Label clockValue;
	private Label lastBaseLabel;
	private Label lastBaseValue;
	private Label energyLevelLabel; 
	private Label energyLevelValue; 
	private Label damageLevelLabel;
	private Label damageLevelValue;
	private Label soundLabel;
	private Label soundValue;
	
	public ScoreView(Observable myModel) {
		
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		
		this.setLayout(new FlowLayout(Component.CENTER));
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.GRAY));
		
		// Add the Labels to the GUI
		this.setupLabels();
		this.add(clockLabel);
		this.add(clockValue);
		this.add(livesLabel);
		this.add(livesValue);
		this.add(lastBaseLabel);
		this.add(lastBaseValue);
		this.add(energyLevelLabel);
		this.add(energyLevelValue);
		this.add(damageLevelLabel);
		this.add(damageLevelValue);
		this.add(soundLabel);
		this.add(soundValue);
	}

	
	public void setupLabels() 
	{

		// These are the labels for north container that goes under Game Name
		livesLabel = new Label("Lives: ");
		livesValue = new Label("" + model.getLivesLeft());
		livesLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		livesValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		clockLabel = new Label("Time: ");
		clockValue = new Label("" + model.getClock());
		clockLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		clockValue.getAllStyles().setFgColor(ColorUtil.BLUE);


		lastBaseLabel = new Label("Player Last Base Reached: ");
		lastBaseValue = new Label("" + model.getRobotLastBaseReached());
		lastBaseLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		lastBaseValue.getAllStyles().setFgColor(ColorUtil.BLUE);

		
		energyLevelLabel = new Label("Energy level: ");
		energyLevelValue = new Label("" + model.getEnergyLevel());
		energyLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		energyLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);

		
		
		damageLevelLabel = new Label("Damage Level: ");
		damageLevelValue = new Label("" + model.getDamageLevel());
		damageLevelLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		damageLevelValue.getAllStyles().setFgColor(ColorUtil.BLUE);

		
		soundLabel = new Label("Sound: ");
		soundValue = new Label("" + model.isSound());
		soundLabel.getAllStyles().setFgColor(ColorUtil.BLUE);
		soundValue.getAllStyles().setFgColor(ColorUtil.BLUE);

		
	}
	
	public void updateLabels() {
		
		clockValue.setText("" + model.getClock());
		clockValue.getParent().revalidate();
		livesValue.setText("" + model.getLivesLeft());
		livesValue.getParent().revalidate();
		
		lastBaseValue.setText("" + model.getRobotLastBaseReached());
		lastBaseValue.getParent().revalidate();
		energyLevelValue.setText("" + model.getEnergyLevel());
		energyLevelLabel.getParent().revalidate();
		damageLevelValue.setText("" + model.getDamageLevel());
		damageLevelValue.getParent().revalidate();
		soundValue.setText("" + model.isSound());
		soundValue.getParent().revalidate();
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		this.updateLabels();
	}
	
}

