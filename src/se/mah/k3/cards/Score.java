package se.mah.k3.cards;
import android.util.Log;


public class Score {
	
		
		public int points = 0;
		public String pointsString = "";
		
		public Score (Boolean isSet){
		}
		
		public String getPoints(){
			pointsString = Integer.toString(points);
			Log.i("score", "returns points");
			return pointsString;
		}
		
		public int addPoints(){
			points = points+1000;
			Log.i("score", "adds points");
			return points;
		}

	}
