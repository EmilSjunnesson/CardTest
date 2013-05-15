package se.mah.k3.cards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.splash);

		IntentLauncher launcher = new IntentLauncher();
		launcher.start();

	}

	private class IntentLauncher extends Thread {
		
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				Log.e("TagBag", "could not load application");
			}
			
			//Start main activity
			Intent intent = new Intent(SplashScreen.this, MainActivity.class);
			SplashScreen.this.startActivity(intent);
			SplashScreen.this.finish();
		}
	}

}
