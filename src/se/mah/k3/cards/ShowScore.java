package se.mah.k3.cards;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowScore extends Activity {

	Controller controller;
	Highscore highscore;
	Typeface typeFace;
	TextView[] tv;
	Dialog winDialog;
	ImageButton winYes, winNo;
	ImageView bg;
	private int score, timeBonusSec, finalScore;
	private double scoreD, timeBonusSecD, timeBonusMinD, finalScoreD;

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

		// get extras from MainActivity
		score = getIntent().getExtras().getInt("score");
		timeBonusSec = getIntent().getExtras().getInt("Timebonus");

		//conversion
		scoreD = (double) score;
		timeBonusSecD = (double) timeBonusSec;
		timeBonusMinD = roundToDecimals(timeBonusSecD / 60, 2);
		finalScoreD = calculateFinalScore(scoreD, timeBonusMinD);
		finalScore = (int) finalScoreD;

		setupUI();
		tv[1].setText(Integer.toString(score));
		tv[3].setText(Double.toString(timeBonusMinD));
		tv[5].setText(Integer.toString(finalScore));
	}

	public void checkForHighscore() {
		if (score > highscore.getScore(9)) {
			// if you got a new highscore
			Intent highScoreIntent = new Intent(getApplicationContext(),
					WriteHighScore.class);
			highScoreIntent.putExtra("finalScore", finalScore);
			startActivity(highScoreIntent);
			finish();
		} else {
			// popup
			winDialog.show();
		}
	}

	// Listener to dialog buttons and background
	public OnClickListener scoreListener = new OnClickListener() {

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
			case R.id.calculate_final_highscore_background:
				checkForHighscore();
				break;
			}
		}
	};
	
	// get final score from time and score
	public double calculateFinalScore(double s, double tb) {
		double fs = 0;
		fs = s+(s/tb*10);
		return fs;
	}
	
	//round double
	public static double roundToDecimals(double d, int c) {
		int temp = (int) ((d * Math.pow(10, c)));
		return (((double) temp) / Math.pow(10, c));
	}
	
	public void setupUI() {
		// setup dialog
		winDialog = new Dialog(ShowScore.this);
		winDialog = controller.createCustomDialog(winDialog,
				R.layout.win_dialog);
		winYes = (ImageButton) winDialog.findViewById(R.id.winYes);
		winYes.setOnClickListener(scoreListener);
		winNo = (ImageButton) winDialog.findViewById(R.id.winNo);
		winNo.setOnClickListener(scoreListener);

		typeFace = Typeface.createFromAsset(getAssets(), "fonts/black.ttf");
		
		bg = (ImageView) findViewById(R.id.calculate_final_highscore_background);
		bg.setOnClickListener(scoreListener);

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
			tv[i].setTextColor(Color.parseColor("#D9BD8C"));
		}
	}
}
