package se.mah.k3.cards;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HighScoreView extends Activity {

	TextView score1, score2, score3, score4, score5, score6, score7, score8,
			score9, score10, name1, name2, name3, name4, name5, name6, name7,
			name8, name9, name10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.highscore_view);
	}

}
