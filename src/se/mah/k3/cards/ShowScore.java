package se.mah.k3.cards;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class ShowScore extends Activity {

	Controller controller;
	Highscore highscore;
	Typeface typeFace;
	TextView[] tv;
	Dialog winDialog;
	ImageButton winYes, winNo;
	private int score;
	private int time;

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

		// setup dialog
		winDialog = new Dialog(ShowScore.this);
		winDialog = controller.createCustomDialog(winDialog,
				R.layout.win_dialog);
		winYes = (ImageButton) winDialog.findViewById(R.id.winYes);
		winYes.setOnClickListener(dialogListener);
		winNo = (ImageButton) winDialog.findViewById(R.id.winNo);
		winNo.setOnClickListener(dialogListener);

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

	public void checkForHighscore() {
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

	// Listener to dialog buttons
	public OnClickListener dialogListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.winYes:
				Intent replay = new Intent(ShowScore.this, MainActivity.class);
				startActivity(replay);
				finish();
				break;
			case R.id.winNo:
				Intent menu = new Intent(ShowScore.this, StartScreen.class);
				startActivity(menu);
				finish();
				break;
			}
		}
	};

}
