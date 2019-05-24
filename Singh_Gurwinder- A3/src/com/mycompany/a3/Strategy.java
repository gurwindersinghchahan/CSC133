package com.mycompany.a3;

import com.codename1.util.MathUtil;

public abstract  class Strategy {
	private GameWorld gw;
	private NonPlayerRobot npr;
	
	public void setGameWorld( GameWorld gw ) {
		this.gw = gw;
	}
	
	public GameWorld getGameWorld() {
		return gw;
	}
	
	public void setNPC( NonPlayerRobot newNpr) {
		npr = newNpr;
	}
	
	public NonPlayerRobot getNPC() {
		return npr;
	}
	
	public abstract void apply();
	
	
	public int getHeading() {
		
		double deltaX = (Math.cos(Math.toRadians(90 - this.getHeading())) );
		double deltaY = (Math.sin(Math.toRadians(90 - this.getHeading())) );
		
		boolean shouldAddPi = (deltaX < 0);
		
		if(deltaX == 0) {
			deltaY = 0;
			deltaX = 1;
		}

		double radians = MathUtil.atan( (double)deltaY / (double)deltaX );
		int degrees = (int)(radians * 180.0 / Math.PI);
		
		if (shouldAddPi) {
			degrees += 180;
		}
		
		while(degrees < 0) {
			degrees += 360;
		}
		
		while(degrees >= 360) {
			degrees -= 360;
		}
		
		degrees = 90 - degrees;
		
		return degrees;
	}
}
