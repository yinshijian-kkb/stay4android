package com.zixing.phil.dealing;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.SuperscriptSpan;
import android.widget.TextView;

public class SuperscriptSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String text =  "23 + 34= 89 ——2的3次方加3的4次方等于89.";
		
		Spannable spn = SpannableStringBuilder.valueOf(text);
		spn.setSpan(new SuperscriptSpan(), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(new SuperscriptSpan(), 6, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "SuperscriptSpan，上标样式，比如数学上的次方运算，当然，还可以对上标文字进行缩放。构造函数：\n" +
				"SuperscriptSpan()：无参构造。\n" +
				"SuperscriptSpan(Parcel src)：一参构造，参数src并未起任何作用，源码中为：\n"+
				"public SuperscriptSpan(Parcel src) {\n"+
				"}";
		txtIntro.setText(intro);
	}
	
}
