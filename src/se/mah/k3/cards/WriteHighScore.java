package se.mah.k3.cards;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WriteHighScore extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write_highscore);
		String highScore = Integer.toString(getIntent().getExtras().getInt(
				"score"));
		TextView highScoretv = (TextView) findViewById(R.id.HSText);
		highScoretv.setText(highScore);
	}
}
