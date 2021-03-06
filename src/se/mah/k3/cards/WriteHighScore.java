package se.mah.k3.cards;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class WriteHighScore extends Activity {

	private long score;
	private String name;
	EditText player;
	TextView scoreview;
	Typeface typeFace;
	Highscore highscore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//disable kayboard at start
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		setContentView(R.layout.write_highscore);

		// get score from MainActivity
		score = (long) getIntent().getExtras().getInt("finalScore");

		typeFace = Typeface.createFromAsset(getAssets(), "fonts/black.ttf");

		player = (EditText) findViewById(R.id.player); // edittext component
		scoreview = (TextView) findViewById(R.id.scoreview); // textview
		scoreview.setTypeface(typeFace);
		scoreview.setTextColor(Color.BLACK);

		highscore = new Highscore(this);
		scoreview.setText(String.valueOf(score));

		// override button on keyboard
		player.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if ((event.getAction() == KeyEvent.ACTION_DOWN)
						&& (keyCode == KeyEvent.KEYCODE_ENTER)) {
					name = player.getText().toString();
					// adds score to highscore
					highscore.addScore(name, score);
					// start next activity
					Intent intent = new Intent(WriteHighScore.this,
							HighScoreView.class);
					startActivity(intent);
					finish();
				}
				return false;
			}
		});

	}
}
