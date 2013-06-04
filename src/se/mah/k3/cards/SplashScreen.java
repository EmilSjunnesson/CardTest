package se.mah.k3.cards;



import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class SplashScreen extends Activity {
	
	
	
	
	ProgressBar myprogress;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.splash);						
		myprogress=(ProgressBar) findViewById(R.id.myprogress);
		new ShowDialogAsyncTask().execute();
		
	}
	private class ShowDialogAsyncTask extends AsyncTask<Void, Integer, Void>{
		 
	    int progress_status;
	     
	    @Override
	 protected void onPreExecute() {
	  super.onPreExecute();
	   
	   

	   progress_status = 0;
	  
	   
	   
	 }
	 
	    @Override
		  protected Void doInBackground(Void... params) {
		    
		   while(progress_status<100){
		     
		    progress_status += 2;
		     
		    publishProgress(progress_status);
		    SystemClock.sleep(80);
		     
		   }
		   return null;
		  }
		
	    @Override
		  protected void onProgressUpdate(Integer... values) {
		   super.onProgressUpdate(values);
		    
		   myprogress.setProgress(values[0]);
		  
		 
		  }
		   
		  @Override
		  protected void onPostExecute(Void result) {
		   super.onPostExecute(result);
		   Intent intent = new Intent(SplashScreen.this, StartScreen.class);
			SplashScreen.this.startActivity(intent);
			SplashScreen.this.finish();
		     		   
		  }
		    }		
}
