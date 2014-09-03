package org.vkedco.mobappdev.kit_kat_quotes;


import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

// bugs to vladimir dot kulyukin at gmail dot com

public class KitKatQuotes extends Activity {
	
	Button mBtnToastQuote = null;
	KitKatQuotes mThisApp = null;
	Toast mToast = null;
	
	static ArrayList<Quote> mQuotes = new ArrayList<Quote>();
	static Random mRandom = new Random();
	
	final static String LOG_TAG = KitKatQuotes.class.getSimpleName() + "_TAG";
	
	static {
		mQuotes.add(new Quote("Knowledge is knowledge, and vice versa", "U of Berkekley T-shirt"));
		mQuotes.add(new Quote("The fruits of righteousness are sown in peace by those who keep peace",
				"James 3:18"));
		mQuotes.add(new Quote("My dear, here we must run as fast as we can, just to remain in place",
				"L. Carrol, Alice in Wonderland"));
		mQuotes.add(new Quote("It's not the eyes that are blind, but the hearts.",
				"Quran 22:46"));
		mQuotes.add(new Quote("Blessed are the peacemakers, for they shall be called the children of God",
				"Matthew 5:9"));
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mThisApp = this;
		setContentView(R.layout.activity_kit_kat_quotes);
		// this is where the button XML inflation happens.
		this.mBtnToastQuote = (Button) this.findViewById(R.id.btnToastQuoate);
		this.mToast = Toast.makeText(this, "Static Toast", Toast.LENGTH_LONG);
		this.mBtnToastQuote.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final String quote = mThisApp.getRandomQuote().toString();
				
				mThisApp.mToast.setText(quote.toString());
				mThisApp.mToast.show();
				Log.v(KitKatQuotes.LOG_TAG, quote);
			}
		});
		
		
	}
	
	private Quote getRandomQuote() {
		return mQuotes.get(mRandom.nextInt(KitKatQuotes.mQuotes.size()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kit_kat_quotes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
