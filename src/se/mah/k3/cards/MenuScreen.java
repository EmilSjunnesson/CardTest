package se.mah.k3.cards;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

public class MenuScreen extends Activity {

	public MenuScreen(){
		
		final ImageView display;
		//Skapar en mediaplayer som spelar ljud n�r man trycker p� korten
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.playbutton);
		
		//G�r en imageview av playkortet
		final ImageView playcard = (ImageView) findViewById(R.id.playcard);
		//G�r en imageview av highscorekortet
		final ImageView highscorecard = (ImageView) findViewById(R.id.highscorecard);
		
		//Ljud f�r playkortet
		playcard.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.start();
				switch(v.getId()){
				case R.drawable.playkort:
					break;
				}
				
			}
		});
		
		//Ljud f�r highscorekortet
		highscorecard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.start();
				switch(v.getId()){
				case R.drawable.highscorekort:
					break;
				}
				
			}
		});
		
		
		
		
	
}
}
