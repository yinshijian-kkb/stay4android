package com.zixing.phil.dealing;

import android.graphics.Typeface;
import android.os.Parcel;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class StyleSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String sentence = "StyleSpan set the style of the text.";
		int l1 = sentence.length();
		
		StyleSpan ssBold = new StyleSpan(Typeface.BOLD);
		StyleSpan ssItalic = new StyleSpan(Typeface.ITALIC);
		Parcel p = Parcel.obtain();
		p.writeInt(Typeface.BOLD_ITALIC);
		p.setDataPosition(0);
		StyleSpan ssBI = new StyleSpan(p);
		Spannable spn = SpannableStringBuilder.valueOf(sentence);
		spn.setSpan(ssBold, 10, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(ssItalic, 18, 26, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(ssBI, 26, l1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "StyleSpan，主要由正常、粗体、斜体和同时加粗倾斜四种样式，常量值定义在Typeface类中。" +
				"构造函数：\n" +
				"StyleSpan(int style)：参数style，定义在Typeface中的常量。\n" +
				"StyleSpan(Parcel src)：参数src，包含字体信息的包装类，用法：\n" +
				"Parcel p = Parcel.obtain();\n"+
				"p.writeInt(Typeface.BOLD_ITALIC);\n"+
				"p.setDataPosition(0);\n"+
				"StyleSpan ss = new StyleSpan(p);";
		txtIntro.setText(intro);
	}
	
}
