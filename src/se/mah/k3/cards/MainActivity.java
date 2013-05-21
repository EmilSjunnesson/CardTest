package se.mah.k3.cards;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.app.Activity;

public class MainActivity extends Activity {
	
	Controller controller = new Controller();
	ImageView[] iv = new ImageView[12];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		setupImageViews();
		cardImages(controller.getActiveCards(12));
		// controller.placeCardsOnTable(12);
		// controller.placeCardsOnTable(3);
		Log.i("TagBag", "Kort aktiva: " + controller.activeCards.size());
	}

	public OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.card1:
				Log.i("TagBag", controller.activeCards.get(0).toString());
				
				break;
			case R.id.card2:
				Log.i("TagBag", controller.activeCards.get(1).toString());
				break;
			case R.id.card3:
				Log.i("TagBag", controller.activeCards.get(2).toString());
				break;
			case R.id.card4:
				Log.i("TagBag", controller.activeCards.get(3).toString());
				break;
			case R.id.card5:
				Log.i("TagBag", controller.activeCards.get(4).toString());
				break;
			case R.id.card6:
				Log.i("TagBag", controller.activeCards.get(5).toString());
				break;
			case R.id.card7:
				Log.i("TagBag", controller.activeCards.get(6).toString());
				break;
			case R.id.card8:
				Log.i("TagBag", controller.activeCards.get(7).toString());
				break;
			case R.id.card9:
				Log.i("TagBag", controller.activeCards.get(8).toString());
				break;
			case R.id.card10:
				Log.i("TagBag", controller.activeCards.get(9).toString());
				break;
			case R.id.card11:
				Log.i("TagBag", controller.activeCards.get(10).toString());
				break;
			case R.id.card12:
				Log.i("TagBag", controller.activeCards.get(11).toString());
				break;
			}
		}

	};

	public void setupImageViews() {
		iv[0] = (ImageView) findViewById(R.id.card1);
		iv[1] = (ImageView) findViewById(R.id.card2);
		iv[2] = (ImageView) findViewById(R.id.card3);
		iv[3] = (ImageView) findViewById(R.id.card4);
		iv[4] = (ImageView) findViewById(R.id.card5);
		iv[5] = (ImageView) findViewById(R.id.card6);
		iv[6] = (ImageView) findViewById(R.id.card7);
		iv[7] = (ImageView) findViewById(R.id.card8);
		iv[8] = (ImageView) findViewById(R.id.card9);
		iv[9] = (ImageView) findViewById(R.id.card10);
		iv[10] = (ImageView) findViewById(R.id.card11);
		iv[11] = (ImageView) findViewById(R.id.card12);

		for (int i = 0; i < iv.length; i++) {
			iv[i].setOnClickListener(onClickListener);
		}
	}

	public void cardImages(ArrayList<Card> activeCards) {
		for (int i = 0; i < iv.length; i++) {
			iv[i].setImageResource(activeCards.get(i).getResId());
		}
	}

}
