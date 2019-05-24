package com.mycompany.a2;
import java.util.*;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;
import java.util.Observable;
import java.util.Observer;
import com.codename1.ui.Container;


public class MapView extends Container  implements Observer  // Mapview implemets observer
{
	private GameWorld model;

		MapView(Observable myModel) 
		{
			model = (GameWorld) myModel;
			myModel.addObserver(this);
			this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255,0,0)));// Creating the red line border around the container
	
		}
	

	public void update(Observable observable, Object data) {
		{
			model.map();
			
		}
		
	}

}
