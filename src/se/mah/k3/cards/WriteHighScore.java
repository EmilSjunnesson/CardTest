package se.mah.k3.cards;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class WriteHighScore extends Activity {
	
	private long score;
	private String name;
	EditText player;
	TextView scoreview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write_highscore);
		
		player = (EditText)findViewById(R.id.player); //edittext komponent
		scoreview = (TextView)findViewById(R.id.scoreview); //textview komponent
		
		player.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if((event.getAction() == KeyEvent.ACTION_DOWN)&&(keyCode == KeyEvent.KEYCODE_ENTER)){
					
				}
				return false;
			}
		});
		
		score = getIntent().getExtras().getLong("score");
	}
}
