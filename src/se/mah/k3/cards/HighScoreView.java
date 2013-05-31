package se.mah.k3.cards;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class HighScoreView extends Activity {

	TextView score1, score2, score3, score4, score5, score6, score7, score8,
			score9, score10, name1, name2, name3, name4, name5, name6, name7,
			name8, name9, name10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		score1 = (TextView) findViewById(R.id.score1);
		score2 = (TextView) findViewById(R.id.score2);
		score3 = (TextView) findViewById(R.id.score3);
		score4 = (TextView) findViewById(R.id.score4);
		score5 = (TextView) findViewById(R.id.score5);
		score6 = (TextView) findViewById(R.id.score6);
		score7 = (TextView) findViewById(R.id.score7);
		score8 = (TextView) findViewById(R.id.score8);
		score9 = (TextView) findViewById(R.id.score9);
		score10 = (TextView) findViewById(R.id.score10);
		
		name1 = (TextView) findViewById(R.id.name1);
		name2 = (TextView) findViewById(R.id.name2);
		name3 = (TextView) findViewById(R.id.name3);
		name4 = (TextView) findViewById(R.id.name4);
		name5 = (TextView) findViewById(R.id.name5);
		name6 = (TextView) findViewById(R.id.name6);
		name7 = (TextView) findViewById(R.id.name7);
		name8 = (TextView) findViewById(R.id.name8);
		name9 = (TextView) findViewById(R.id.name9);
		name10 = (TextView) findViewById(R.id.name10);
		

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.highscore_view);
	}

}
