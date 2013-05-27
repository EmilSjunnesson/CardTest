package se.mah.k3.cards;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartScreen extends Activity {
	Animation startanim1;
	Animation startanim2;
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
		startanim1= AnimationUtils.loadAnimation(this, R.anim.menuanim1);
		startanim2= AnimationUtils.loadAnimation(this, R.anim.menuanim2);
		setContentView(R.layout.menuscreen);
		// Gšr en imageview av playkortet
		ImageView playcard = (ImageView) findViewById(R.id.playcard);
		// Gšr en imageview av highscorekortet
		ImageView highscorecard = (ImageView) findViewById(R.id.highscorecard);
		// Ljud fšr playkortet
		startmusic.setLooping(true);
		startmusic.start();
		playcard.startAnimation(startanim1);
		highscorecard.startAnimation(startanim2);
		
		playcard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				startsound.seekTo(0);
				startsound.start();
				
				
				startmusic.pause();
				
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
	
		
@Override
protected void onPause(){
	super.onPause();
	startmusic.pause();
}
@Override
protected void onResume(){
	super.onResume();
	startmusic.start();	
	
}
@Override
protected void onDestroy(){
	super.onDestroy();
	startmusic.release();
	startsound.release();
}
}

