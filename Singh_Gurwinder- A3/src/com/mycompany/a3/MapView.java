package com.mycompany.a3;

import java.util.Observer;
import java.util.Observable;

import com.codename1.ui.geom.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private GameWorld model;
	
	public MapView(Observable myModel) {
		model = (GameWorld) myModel;
		myModel.addObserver(this);
		this.getAllStyles().setBorder(Border.createLineBorder(4,
				ColorUtil.rgb(255,0,0)));
		this.getAllStyles().setBgColor(0xffffff);
	}
	
	public MapView () {
		
	}

	public void update (Observable o, Object arg) {
		//code to call the method in GameWorld (Observable) that output the 
		//game object info to the console
		this.repaint();
		model.showMap();
	
	}
	
	public int getMapWidth() {
		
		return getComponentForm().getWidth() - (2 * getX());
	}
	
	public int getMapHeight() {
		
		return getHeight();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(), getY());
		System.out.println("" + getX());
		model.draw(g, pCmpRelPrnt);
		
		GameObjectCollection theCollection = model.getGameObjectCollection();
		IIterator theSelectors = theCollection.getIterator();
		while(theSelectors.hasNext()){
			GameObject curObj = (GameObject)theSelectors.getNext();
			if ((curObj instanceof Bases || curObj instanceof EnergyStations) && model.getPaused() == false) {
				((ISelectable)curObj).setSelected(false);
			}	
		}
	}
	
	

	public void pointerPressed(int x, int y) { 
		if (model.getPaused() == false ) {
			return;
		}
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY(); 
		Point pPtrRelPrnt = new Point(x, y);
	       
		Point pCmpRelPrnt = new Point(getX(), getY());
		GameObjectCollection theCollection = model.getGameObjectCollection();
		
		IIterator theSelectors = theCollection.getIterator();
		
		while(theSelectors.hasNext()){
			GameObject curObj = (GameObject)theSelectors.getNext();
			if (curObj instanceof Bases || curObj instanceof EnergyStations) {
				
				//check if it was selected so we can move it
				if (((ISelectable)curObj).isSelected() && model.getIsPositionable()) {
					((GameObject)curObj).setXlocation(x - getX() - curObj.getSize() / 2, getMapHeight(), getMapWidth());
					((GameObject)curObj).setYlocation(y - getY() - curObj.getSize() / 2, getMapHeight(), getMapWidth());
					((ISelectable)curObj).setSelected(false);
					model.setPositionable(false);
					
				} else if(((ISelectable)curObj).contains(pPtrRelPrnt, pCmpRelPrnt)) {
					((ISelectable)curObj).setSelected(true);
					
				}
				else {
					((ISelectable)curObj).setSelected(false);
				}
			
			}
			update(model,null);
			repaint(); 
			
		}
	}
		

}


