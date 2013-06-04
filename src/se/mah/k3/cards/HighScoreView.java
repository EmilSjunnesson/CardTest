package se.mah.k3.cards;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class HighScoreView extends Activity {

	AnimationDrawable highscoreAnim;
	ImageView highscoreview;
	Typeface typeFace;
	Highscore highscore;
	Animation fadein;
	Animation fadeout;
	boolean showtext=false;
	int frames=0;
	TextView[] tv1;
	TextView[] tv2;
	TextView[] tv3; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.highscore_view);
		
		highscore = new Highscore(this);
		highscoreview = (ImageView) findViewById(R.id.highscoreview);
		highscoreview.setBackgroundResource(R.drawable.highscore_anim);
		highscoreAnim = (AnimationDrawable) highscoreview.getBackground();
		fadein=AnimationUtils.loadAnimation(this, R.anim.highscorefade);
		fadeout=AnimationUtils.loadAnimation(this, R.anim.highscorefadeout);
		
		typeFace = Typeface.createFromAsset(getAssets(),
					"fonts/black.ttf");
		
	
		 tv1 = new TextView[10];
		tv1[0] = (TextView) findViewById(R.id.score1);
		tv1[1] = (TextView) findViewById(R.id.score2);
		tv1[2] = (TextView) findViewById(R.id.score3);
		tv1[3] = (TextView) findViewById(R.id.score4);
		tv1[4] = (TextView) findViewById(R.id.score5);
		tv1[5] = (TextView) findViewById(R.id.score6);
		tv1[6] = (TextView) findViewById(R.id.score7);
		tv1[7] = (TextView) findViewById(R.id.score8);
		tv1[8] = (TextView) findViewById(R.id.score9);
		tv1[9] = (TextView) findViewById(R.id.score10);

		 tv2 = new TextView[10];
		tv2[0] = (TextView) findViewById(R.id.name1);
		tv2[1] = (TextView) findViewById(R.id.name2);
		tv2[2] = (TextView) findViewById(R.id.name3);
		tv2[3] = (TextView) findViewById(R.id.name4);
		tv2[4] = (TextView) findViewById(R.id.name5);
		tv2[5] = (TextView) findViewById(R.id.name6);
		tv2[6] = (TextView) findViewById(R.id.name7);
		tv2[7] = (TextView) findViewById(R.id.name8);
		tv2[8] = (TextView) findViewById(R.id.name9);
		tv2[9] = (TextView) findViewById(R.id.name10);
		
		 tv3 = new TextView[10];
		tv3[0] = (TextView) findViewById(R.id.placing1);
		tv3[1] = (TextView) findViewById(R.id.placing2);
		tv3[2] = (TextView) findViewById(R.id.placing3);
		tv3[3] = (TextView) findViewById(R.id.placing4);
		tv3[4] = (TextView) findViewById(R.id.placing5);
		tv3[5] = (TextView) findViewById(R.id.placing6);
		tv3[6] = (TextView) findViewById(R.id.placing7);
		tv3[7] = (TextView) findViewById(R.id.placing8);
		tv3[8] = (TextView) findViewById(R.id.placing9);
		tv3[9] = (TextView) findViewById(R.id.placing10);
		
		for (int i=0;i<tv1.length;i++){
			tv1[i].setVisibility(View.INVISIBLE);
			tv2[i].setVisibility(View.INVISIBLE);
			tv3[i].setVisibility(View.INVISIBLE);
		}
		//display score
		for (int i = 0; i < tv1.length; i++) {
			tv1[i].setTypeface(typeFace);
			tv1[i].setTextColor(Color.BLACK);
			tv1[i].setText(String.valueOf(highscore.getScore(i)));
		}
		
		//display names
		for (int i = 0; i < tv2.length; i++) {
			tv2[i].setTypeface(typeFace);
			tv2[i].setTextColor(Color.BLACK);
			tv2[i].setText(highscore.getName(i));
		}
		
		//display placing
		for (int i = 0; i < tv3.length; i++) {
			tv3[i].setTypeface(typeFace);
			tv3[i].setTextColor(Color.BLACK);
		}
		highscoreAnim.start();					      															
	for (int i=0;i<tv1.length;i++){
		tv1[i].startAnimation(fadein);
		tv2[i].startAnimation(fadein);
		tv3[i].startAnimation(fadein);
	}
	highscoreview.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			for(int i=0;i<tv1.length;i++){
				tv1[i].startAnimation(fadeout);
				tv2[i].startAnimation(fadeout);
				tv3[i].startAnimation(fadeout);
			}
			fadeout.setAnimationListener(new AnimationListener() {
				
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
					Intent i = new Intent(HighScoreView.this, StartScreen.class);
					startActivity(i);
					finish();	
				}
			});
			
			
		}
	});
	}
	

	public void onBackPressed() {
		for(int i=0;i<tv1.length;i++){
			tv1[i].startAnimation(fadeout);
			tv2[i].startAnimation(fadeout);
			tv3[i].startAnimation(fadeout);
			
			fadeout.setAnimationListener(new AnimationListener() {
				
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
					Intent i = new Intent(HighScoreView.this, StartScreen.class);
					startActivity(i);
					finish();	
				}
			});
		}
		return;
	}
}
