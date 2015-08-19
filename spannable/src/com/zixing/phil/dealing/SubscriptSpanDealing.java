package com.zixing.phil.dealing;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.SubscriptSpan;
import android.widget.TextView;

public class SubscriptSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String text = "Cu2(OH)2CO3-碱式碳酸铜";
		
		Spannable spn = SpannableStringBuilder.valueOf(text);
		spn.setSpan(new SubscriptSpan(), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(new SubscriptSpan(), 7, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(new SubscriptSpan(), 10, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "SubscriptSpan,脚注样式，比如化学式的常见写法，当然，还可以对脚注的文字做一定的缩放。构造函数：\n" +
				"SubscriptSpan()：无参构造。\n" +
				"SubscriptSpan(Parcel src)：一参构造，参数src并未起任何作用，源码中为：\n"+
				"public SuperscriptSpan(Parcel src) {\n"+
				"}";
		txtIntro.setText(intro);
	}
	
}
