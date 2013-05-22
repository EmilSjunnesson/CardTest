package se.mah.k3.cards;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.app.Activity;

public class MainActivity extends Activity {

	Controller controller;
	ImageView[] iv;
	ImageView[] selectedImg;
	Card currCard, compareCard1, compareCard2, compareCard3;
	private boolean[] toggle;
	private int pressedCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		controller = new Controller();
		iv = new ImageView[12];
		selectedImg = new ImageView[12];
		toggle = new boolean[12];
		pressedCount = 0;

		setupImageViews();
		cardImages(controller.getActiveCards(12));

		Log.i("TagBag", "Kort aktiva: " + controller.activeCards.size());
	}

	public OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.card1:
				toggleState(0);
				break;
			case R.id.card2:
				toggleState(1);
				break;
			case R.id.card3:
				toggleState(2);
				break;
			case R.id.card4:
				toggleState(3);
				break;
			case R.id.card5:
				toggleState(4);
				break;
			case R.id.card6:
				toggleState(5);
				break;
			case R.id.card7:
				toggleState(6);
				break;
			case R.id.card8:
				toggleState(7);
				break;
			case R.id.card9:
				toggleState(8);
				break;
			case R.id.card10:
				toggleState(9);
				break;
			case R.id.card11:
				toggleState(10);
				break;
			case R.id.card12:
				toggleState(11);
				break;
			}
			if (pressedCount == 1) {
				compareCard1 = currCard;
			} else if (pressedCount == 2) {
				compareCard2 = currCard;
			} else if (pressedCount == 3) {
				compareCard3 = currCard;
				Log.i("TagBag", compareCard1.toString());
				Log.i("TagBag", compareCard2.toString());
				Log.i("TagBag", compareCard3.toString());
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

		selectedImg[0] = (ImageView) findViewById(R.id.frame1);
		selectedImg[1] = (ImageView) findViewById(R.id.frame2);
		selectedImg[2] = (ImageView) findViewById(R.id.frame3);
		selectedImg[3] = (ImageView) findViewById(R.id.frame4);
		selectedImg[4] = (ImageView) findViewById(R.id.frame5);
		selectedImg[5] = (ImageView) findViewById(R.id.frame6);
		selectedImg[6] = (ImageView) findViewById(R.id.frame7);
		selectedImg[7] = (ImageView) findViewById(R.id.frame8);
		selectedImg[8] = (ImageView) findViewById(R.id.frame9);
		selectedImg[9] = (ImageView) findViewById(R.id.frame10);
		selectedImg[10] = (ImageView) findViewById(R.id.frame11);
		selectedImg[11] = (ImageView) findViewById(R.id.frame12);
	}

	public void cardImages(ArrayList<Card> activeCards) {
		for (int i = 0; i < iv.length; i++) {
			iv[i].setImageResource(activeCards.get(i).getResId());
		}
	}

	public void toggleState(int pos) {
		toggle[pos] = !toggle[pos];
		if (toggle[pos] == true) {
			selectedImg[pos].setVisibility(View.VISIBLE);
			currCard = controller.getActiveArray().get(pos);
			pressedCount++;
		} else if (toggle[pos] == false) {
			selectedImg[pos].setVisibility(View.INVISIBLE);
			pressedCount--;
		}
	}

}
