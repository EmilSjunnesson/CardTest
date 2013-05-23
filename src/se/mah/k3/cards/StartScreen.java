package se.mah.k3.cards;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class StartScreen extends Activity {
	
	MediaPlayer mediaplayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.menuscreen);
		// Gšr en imageview av playkortet
		ImageView playcard = (ImageView) findViewById(R.id.playcard);
		// Gšr en imageview av highscorekortet
		ImageView highscorecard = (ImageView) findViewById(R.id.highscorecard);

		// Ljud fšr playkortet
		playcard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaplayer == null) {
					mediaplayer = MediaPlayer.create(StartScreen.this, R.raw.playbutton);
					mediaplayer.start();
				}else {
					mediaplayer.stop();
					mediaplayer.release();
					mediaplayer = null;
					mediaplayer = MediaPlayer.create(this, R.raw.playbutton);
					mediaplayer.start();
				}
					
					
					
				}
				
				switch (v.getId()) {
				case R.drawable.playkort:
					break;
				}
				Intent intent = new Intent(v.getContext(), MainActivity.class);
				startActivityForResult(intent, 0);
			}
		});

		// Ljud fšr highscorekortet
		highscorecard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mp.stop();
				mp.start();
				switch (v.getId()) {
				case R.drawable.highscorekort:
					break;
				}

			}
		});

	}

}
