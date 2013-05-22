package se.mah.k3.cards;
import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;


public class Score {

	
	Timer comboTimer = new Timer();
	
	public int points = 0;
	public String pointsString = "";
	int comboScore1 = 0;
	int comboScore2 = 0;
	
	public Score (Boolean isSet){
	}
	
	//Add combo points to "regular" points and return them
	public int getPoints(){
		comboScore2 = convertComboPoints(comboScore1);
		points = points+comboScore2;
		Log.i("score", "returns points");
		
		comboScore1 = 0;
		return points;
	}
	
	//Add 1000 points and start comboTimer to calculate bonus-points
	public int add1000Points(){
		points = points+1000;
		Log.i("score", "adds 1000 points");
		startComboTimer();
		return points;
	}
	
	//Start the time to calculate how much bonus-points you will get
	public int startComboTimer(){
			comboTimer.schedule(new TimerTask() {
		                @Override
		                public void run(){
		                	
			                	Log.i("score", "adds to comboScore");
			                	comboScore1++;
			                	
			                	//If the player takes too long, stop the counter
			                	if(comboScore1 > 100){
			                		cancel();
			                	}
		                	
		                }
		            
		    }, 500, 500);
		
		return comboScore1;
	}
	
	public int convertComboPoints(int comboPoints){
		//converts the points from the comboTimer to the actual points you will get in the game
		int comboPoints2 = 0;
		
		if(comboPoints == 0){
			comboPoints2=0;
			
		//Since addPoints adds 1000 points this calculates -1000 to make the final score correct
		} else if (comboPoints < 15){
			comboPoints2 = 9000;
		} else if(comboPoints < 20 && comboPoints > 15) {
			comboPoints2 = 4000;
		} else if (comboPoints < 30 && comboPoints > 20){
			comboPoints2 = 2000;
		} else if (comboPoints < 45 && comboPoints > 30){
			comboPoints2 = 1000;
		} else if (comboPoints > 45){
			comboPoints2 = 0;
		}
		return comboPoints2;
	}
	
	//Clear all points
	public int clearPoints(){
		points = 0;
		return points;
	}

	}
