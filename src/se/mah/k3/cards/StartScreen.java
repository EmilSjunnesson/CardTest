package se.mah.k3.cards;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartScreen extends Activity {
	
	Animation startanim1, startanim2, clickanim1, clickanim2,changeActivityAnim;
	MediaPlayer startsound,startmusic;
	ImageView playcard,highscorecard,candleAnimView;
	AnimationDrawable candleAnim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//Reference sounds
		startsound = MediaPlayer.create(getApplicationContext(),
				R.raw.playbutton);
		startmusic = MediaPlayer.create(getApplicationContext(),
				R.raw.startmusic);
		
		// Initiate click animations
		startanim1 = AnimationUtils.loadAnimation(this, R.anim.menuanim1);
		startanim2 = AnimationUtils.loadAnimation(this, R.anim.menuanim2);
		clickanim1 = AnimationUtils.loadAnimation(this, R.anim.menuanim3);
		clickanim2 = AnimationUtils.loadAnimation(this, R.anim.menuanim4);
		changeActivityAnim = AnimationUtils.loadAnimation(this, R.anim.changeactivityfrom);
		setContentView(R.layout.menuscreen);
		
		// Initiate ImageViews
		playcard = (ImageView) findViewById(R.id.playcard);
		highscorecard = (ImageView) findViewById(R.id.highscorecard);
		candleAnimView = (ImageView) findViewById(R.id.candles);
		candleAnimView.setBackgroundResource(R.drawable.candle_anim);
		candleAnim= (AnimationDrawable) candleAnimView.getBackground();
		
		// Initiate sounds
		startmusic.setLooping(true);
		startsound.setVolume(0.2f, 0.2f);
		startmusic.start();
		
		//Initiate start animations
		playcard.startAnimation(startanim1);
		highscorecard.startAnimation(startanim2);
		candleAnim.start();
		playcard.setVisibility(View.VISIBLE);
		candleAnimView.setVisibility(View.INVISIBLE);
		
		//Playcard listener
		playcard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				playcard.startAnimation(clickanim1);
				startsound.seekTo(0);
				startsound.start();
				
			}
		});
		
		//Click playcard animation listener
		clickanim1.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivityForResult(intent, 0);
				
				playcard.setVisibility(View.INVISIBLE);
				startmusic.reset();
				overridePendingTransition(R.anim.changeactivityto, R.anim.changeactivityfrom);
				finish();
			}
		});

		//Highscore card listener
		highscorecard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				highscorecard.startAnimation(clickanim2);
				startsound.seekTo(0);
				startsound.start();
				startmusic.pause();
			}
		});
		
		//Click highscore animation listener
		clickanim2.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent = new Intent(getApplicationContext(),
						HighScoreView.class);
				startActivityForResult(intent, 0);
				highscorecard.setVisibility(View.INVISIBLE);
				overridePendingTransition(R.anim.changeactivityto, R.anim.changeactivityfrom);
				finish();
			}
		});
		
		//Start animation listener for starting flames
		startanim1.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				candleAnimView.setVisibility(View.VISIBLE);
				candleAnim.start();
			
			}
		});
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		startmusic.pause();
		//candleAnim.stop();
		//candleAnimView.setVisibility(View.INVISIBLE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		startmusic.start();
		playcard.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		startmusic.release();
		startsound.release();
		
	}
}
