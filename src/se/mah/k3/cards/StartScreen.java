package se.mah.k3.cards;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class StartScreen extends Activity {
	
	MediaPlayer startsound;
	MediaPlayer startmusic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		startsound=MediaPlayer.create(getApplicationContext(), R.raw.playbutton);
		startmusic=MediaPlayer.create(getApplicationContext(), R.raw.startmusic);
		setContentView(R.layout.menuscreen);
		// Gšr en imageview av playkortet
		ImageView playcard = (ImageView) findViewById(R.id.playcard);
		// Gšr en imageview av highscorekortet
		ImageView highscorecard = (ImageView) findViewById(R.id.highscorecard);
		// Ljud fšr playkortet
		startmusic.setLooping(true);
		startmusic.start();
		playcard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					
				startsound.seekTo(0);
				startsound.start();
				
				
				
				Intent intent = new Intent(v.getContext(), MainActivity.class);
				startActivityForResult(intent, 0);
			}
		});

		// Ljud fšr highscorekortet
		highscorecard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					
					
						startsound.seekTo(0);
						startsound.start();
					
					
					
				switch (v.getId()) {
				case R.drawable.highscorekort:
					break;
				}

			}
		});

	}

}
