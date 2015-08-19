package com.zixing.phil.dealing;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;

public class StrikethroughSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String sentence = "StrikethroughSpan is a line at the vertical middle position in the text.";
		int l1 = sentence.length();
		
		StrikethroughSpan ss = new StrikethroughSpan();
		Spannable spn = SpannableStringBuilder.valueOf(sentence);
		spn.setSpan(ss, 40, l1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "StrikethroughSpan，删除线样式。该类有两个构造函数：\n" +
				"StrikethroughSpan()和SrickkethroughSapn(Parcel src)。但有参数的构造函数并未对src参数做处理，\n" +
				"public StrikethroughSpan(Parcel src) {\n"+
				"}\n因此这两个构造函数完全是同样的效果。";
		txtIntro.setText(intro);
	}
	
}
