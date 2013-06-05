package se.mah.k3.cards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Creditscreen extends Activity {
Animation scrollanim;
TextView credits;
ImageView cupcake; 
Animation bounce;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);	
		setContentView(R.layout.creditslayout);
		cupcake= (ImageView) findViewById(R.id.cupcake);
		credits=(TextView) findViewById(R.id.credits);
		scrollanim= AnimationUtils.loadAnimation(this,R.anim.scrolltext);
		bounce=AnimationUtils.loadAnimation(this, R.anim.bouncy);
		scrollanim.setRepeatCount(-1);
		credits.startAnimation(scrollanim);
		cupcake.startAnimation(bounce);
	}
	public void onBackPressed() {
		Intent i = new Intent(Creditscreen.this, StartScreen.class);
		startActivity(i);
		finish();	
	}
}
