package se.mah.k3.cards;
import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;


public class Score {
	
	private Timer comboTimer;
	private int points = 0;   //An int that contains the score you get for each set
	private String pointsString = "";
	private int comboScore1 = 0;
	private int comboScore2 = 0;
	
	//return points
	public int getPoints(){
		Log.i("score", "returns points");
		return points;
	}
	
	//Mer logiskt om man r�knar ut comboscore n�r man d�dar timern f�r det h�nger v�l ihop.
	public void killOldTimer(){
		if (comboTimer!=null){
			comboTimer.cancel();
		}
		comboScore2 = convertComboPoints(comboScore1);
		points = points+comboScore2;
		comboScore1 = 0;
	}
	
	//Add 1000 points and start comboTimer to calculate bonus-points
	public void add1000Points(){
		points = points+1000;
		Log.i("score", "adds 1000 points");
	}
	
	//Start the time to calculate how much bonus-points you will get
	public int startComboTimer(){
		comboTimer = new Timer(); //H�r s� vi skapar bara en timer n�r det beh�vs
  		comboTimer.schedule(new TimerTask() {
		                @Override
		                public void run(){
			                Log.i("score", this.toString()+" comboScore: " + comboScore1);
			                comboScore1++;
			                //If the player takes too long, stop the counter
			                if(comboScore1 > 100){
			                	cancel();
			                }
			                
		                }
		            
		    }, 10, 500);
		
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
		} else if (comboPoints < 70 && comboPoints > 45){
			comboPoints2 = 500;
		} else {
			comboPoints2 = 0;
		}
		return comboPoints2;
	}
	
	//Clear all points
	public void clearAll(){		
		clearPoints();
		clearPointsString();
		clearComboScore1();
		clearComboScore2();
	}
	
	public int clearPoints(){
		points = 0;
		return points;
	}
	
	public String clearPointsString(){
		pointsString = "";
		return pointsString;
	}
	
	public int clearComboScore1(){
		comboScore1 = 0;
		return comboScore1;
	}
	
	public int clearComboScore2(){
		comboScore2 = 0;
		return comboScore2;
	}


}
