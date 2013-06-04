package se.mah.k3.cards;

import java.util.Timer;
import java.util.TimerTask;

public class TimebonusTimer {
	
	private Timer timebonusTimer;
	private int timebonus;

	public TimebonusTimer() {
	}
	
	public int startTimebonusTimer(){
		timebonusTimer = new Timer();
		timebonusTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				timebonus++;
				
			}
		}, 5, 1000);
		
		return timebonus;
	}
	
	public int getTimebonus(){
		return timebonus;
	}
	
	public void killTimebonusTimer(){
		if (timebonusTimer!=null){
			timebonusTimer.cancel();
		}
		
	}

}
