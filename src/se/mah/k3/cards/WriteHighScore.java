package se.mah.k3.cards;

import android.app.Activity;
import android.os.Bundle;

public class WriteHighScore extends Activity {
	
	private long score;
	private String name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write_highscore);
		score = getIntent().getExtras().getLong("score");
	}
}
