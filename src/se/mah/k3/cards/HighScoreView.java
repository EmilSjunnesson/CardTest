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
	Highscore highscore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		highscore = new Highscore(this);
		
		TextView[] tv1 = new TextView[10];
		tv1[0] = (TextView) findViewById(R.id.score1);
		tv1[1] = (TextView) findViewById(R.id.score2);
		tv1[2] = (TextView) findViewById(R.id.score3);
		tv1[3] = (TextView) findViewById(R.id.score4);
		tv1[4] = (TextView) findViewById(R.id.score5);
		tv1[5] = (TextView) findViewById(R.id.score6);
		tv1[6] = (TextView) findViewById(R.id.score7);
		tv1[7] = (TextView) findViewById(R.id.score8);
		tv1[8] = (TextView) findViewById(R.id.score9);
		tv1[9] = (TextView) findViewById(R.id.score10);

		TextView[] tv2 = new TextView[10];
		tv2[0] = (TextView) findViewById(R.id.name1);
		tv2[1] = (TextView) findViewById(R.id.name2);
		tv2[2] = (TextView) findViewById(R.id.name3);
		tv2[3] = (TextView) findViewById(R.id.name4);
		tv2[4] = (TextView) findViewById(R.id.name5);
		tv2[5] = (TextView) findViewById(R.id.name6);
		tv2[6] = (TextView) findViewById(R.id.name7);
		tv2[7] = (TextView) findViewById(R.id.name8);
		tv2[8] = (TextView) findViewById(R.id.name9);
		tv2[9] = (TextView) findViewById(R.id.name10);

		for (int i = 0; i < tv1.length; i++) {
			tv1[i].setText(highscore.getName(i));
		}
		for (int i = 0; i < tv2.length; i++) {
			tv2[i].setText(String.valueOf(highscore.getScore(i)));
		}

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.highscore_view);
	}

}
