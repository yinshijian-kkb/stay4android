package com.zixing.phil.dealing;

import android.graphics.Color;
import android.os.Parcel;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.QuoteSpan;
import android.widget.TextView;

public class QuoteSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		 String part1 = "设置了paddingLeft=10\n";
		 String part2 = "第二部分床前明月光，疑是地上霜。举头望明月，低头思故乡。";
		 String part3 = "第三部分";
		 int l1 = part1.length(),l2 = part2.length(),l3 = part3.length();
		 
		 Parcel p = Parcel.obtain();
		 p.writeInt(Color.BLACK);
		 p.setDataPosition(0);
		 
		 QuoteSpan qs = new QuoteSpan(p);
		 Spannable spn = SpannableStringBuilder.valueOf(part1+part2+part3);
		 spn.setSpan(qs, 0, l1+l2+l3, 0);
		 txtResult.setPadding(10, 0, 0, 0);
		 txtResult.setText(spn);
		 
		 String intro = "QuoteSpan，引用样式，在文本左侧添加一条表示引用的竖线，该类有3个构造函数：\n" +
		 		"QuoteSpan()：无参构造，默认颜色为蓝色。\n" +
		 		"QuoteSpan(int color)：参数color，颜色值。\n" +
		 		"QuoteSpan(Parcel src)：包含颜色值信息的包装类。使用：\n" +
		 		"Parcel p = Parcel.obtain();\n"+
		 		"p.writeInt(Color.BLACK);\n"+
		 		"p.setDataPosition(0);\n"+
		 		"QuoteSpan qs = new QuoteSpan(p);";
		 txtIntro.setText(intro);
	}
	
}
