package org.vkedco.mobappdev.kit_kat_quotes;

public class Quote {
	
	String mText = null;
	String mSource = null;
	
	public Quote(String txt, String source) {
		mText = txt;
		mSource = source;
	}
	
	public String toString() {
		return mText + "\n" + mSource;
	}

}
