package se.mah.k3.cards;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.os.Message;

public class TimebonusTimer {
	
	private Timer timebonusTimer;
	private int timebonus;
	private Handler nHandler;
	
	public TimebonusTimer(Handler nHandler) {
		this.nHandler = nHandler;
	}
	
	public int startTimebonusTimer(){
		timebonusTimer = new Timer();
		timebonusTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				timebonus++;
				if (timebonus==60){
					Message msg = new Message();
                	msg.arg1 = MainActivity.SHOW_START_HINT_ONE;
                	nHandler.sendMessage(msg );
				}if (timebonus==90){
					Message msg = new Message();
                	msg.arg1 = MainActivity.SHOW_START_HINT_TWO;
                	nHandler.sendMessage(msg );
				}
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
