package com.zixing.phil.dealing;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class UnderlineSpanDealing {
	public static void show(TextView txtResult,TextView txtIntro){
		String sentence1 = "安能摧眉折腰事权贵，";
		String sentence2 = "使我不得开心颜。";
		int l1 = sentence1.length(),l2 = sentence2.length();
		
		UnderlineSpan us = new UnderlineSpan();
		Spannable spn = SpannableStringBuilder.valueOf(sentence1+sentence2);
		spn.setSpan(us, l1, l1+l2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "UnderlineSpan，下划线样式，给一段文字加上下划线。构造函数：\n" +
				"UnderlineSpan()： 无参构造。\n" +
				"UnderlineSpan(Parcel src)：一参构造， 与无参构造效果相同，构造中未对src做处理。源码：\n" +
				"public UnderlineSpan(Parcel src) {\n"+
				"}";
		txtIntro.setText(intro);
	}
}
