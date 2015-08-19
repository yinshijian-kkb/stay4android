package com.zixing.phil.dealing;

import android.os.Parcel;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

public class RelativeSizeSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String sentence1 = "风劲角弓鸣，将军猎渭城。(0.5f)\n";
		String sentence2 = "草枯鹰眼疾，雪尽马蹄轻。(1.0f)\n";
		String sentence3 = "忽过新丰市，还归细柳营。(1.5f)\n";
		String sentence4 = "回看射雕处，千里暮云平。(默认)";
		int l1 = sentence1.length(),l2 = sentence2.length(),l3 = sentence3.length();
		
		RelativeSizeSpan rss1 = new RelativeSizeSpan(0.5f);
		RelativeSizeSpan rss2 = new RelativeSizeSpan(1.0f);
		Parcel p = Parcel.obtain();
		p.writeFloat(1.5f);
		p.setDataPosition(0);
		RelativeSizeSpan rss3 = new RelativeSizeSpan(p);
		Spannable spn = SpannableStringBuilder.valueOf(sentence1+sentence2+sentence3+sentence4);
		spn.setSpan(rss1, 0, l1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(rss2, l1, l1+l2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(rss3, l1+l2, l1+l2+l3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro ="RelativeSizeSpan，相对大小，指相对于文本设定的大小的相对比例，如果没有设定则采用系统默认值。" +
				"该类有两个构造函数：\n" +
				"RelativeSizeSpan(float proportion)：参数proportion，比例值。如果文字设定大小为A，则显示出来的" +
				"大小为A×proportion。\n" +
				"RelativeSizeSpan(Parcel src)：参数src，包含了比例值信息的包装类。使用：\n" +
				"Parcel p = Parcel.obtain();\n"+
				"p.writeFloat(2.5f);\n"+
				"p.setDataPosition(0);\n"+
				"RelativeSizeSpan rss = new RelativeSizeSpan(p);";
		txtIntro.setText(intro);
	}
	
}
