package se.mah.k3.cards;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ShowScore extends Activity {

	Controller controller;
	Highscore highscore;
	Typeface typeFace;
	TextView[] tv;
	Dialog winDialog;
	private int score;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.calculate_final_highscore);

		controller = new Controller();
		highscore = new Highscore(this);
		
		//setup dialog
		winDialog = new Dialog(ShowScore.this);
		winDialog = controller.createCustomDialog(winDialog,
				R.layout.win_dialog);
//		winYes = (Button) winDialog.findViewById(R.id.winYes);
//		winYes.setOnClickListener(dialogListener);
//		winNo = (Button) winDialog.findViewById(R.id.winNo);
//		winNo.setOnClickListener(dialogListener);

		// get score from MainActivity
		score = getIntent().getExtras().getInt("score");

		typeFace = Typeface.createFromAsset(getAssets(), "fonts/black.ttf");

		tv = new TextView[6];
		tv[0] = (TextView) findViewById(R.id.calculate_highscore_title);
		tv[1] = (TextView) findViewById(R.id.calculate_highscore_highscoreint);
		tv[2] = (TextView) findViewById(R.id.calculate_highscore_timebonus_title);
		tv[3] = (TextView) findViewById(R.id.calculate_highscore_timebonusint);
		tv[4] = (TextView) findViewById(R.id.calculate_highscore_finalscore_title);
		tv[5] = (TextView) findViewById(R.id.calculate_highscore_finalscoreint);	
		
		// changes typeface on textViews
		for (int i = 0; i < tv.length; i++) {
			tv[i].setTypeface(typeFace);
		}
		
	}
	
	public void checkForHighscore(){
		if (score > highscore.getScore(9)) {
			// if you got a new highscore
			Intent highScoreIntent = new Intent(getApplicationContext(),
					WriteHighScore.class);
			highScoreIntent.putExtra("score", score);
			startActivity(highScoreIntent);
			finish();
		} else {
			// popup
			winDialog.show();
		}
	}
	
}
