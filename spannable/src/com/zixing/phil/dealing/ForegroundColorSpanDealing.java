package com.zixing.phil.dealing;

import android.graphics.Color;
import android.os.Parcel;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class ForegroundColorSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String strDefault = "默认颜色：红色";
		String strGreen = "绿色字体";
		String strOrange = "黄色字体";
		int l1 = strDefault.length(),l2 = strGreen.length(),l3 = strOrange.length();
		
		ForegroundColorSpan fcsGreen = new ForegroundColorSpan(Color.rgb(0x00, 0xff, 0x00));
		Parcel p = Parcel.obtain();
		p.writeInt(Color.YELLOW);
		p.setDataPosition(0);
		ForegroundColorSpan fcsYellow = new ForegroundColorSpan(p);
		Spannable spn = SpannableStringBuilder.valueOf(strDefault+strGreen+strOrange);
		spn.setSpan(fcsGreen, l1, l1+l2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		spn.setSpan(fcsYellow, l1+l2, l1+l2+l3, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "ForegroundColorSpan，字体颜色样式，用于改变字体颜色。该类有两个构造函数：\n" +
				"ForegroundColorSpan(int color)\nForegroundColorSpan(Parcel src)\n" +
				"ForegroundColorSpan(int color)：参数color，字体颜色。\n" +
				"ForegroundColorSpan(Parcel src)：参数src，包含字体颜色信息的包装类，使用如下：\n" +
				"Parcel p = Parcel.obtain();\n"+
				"p.writeInt(Color.YELLOW);\n"+
				"p.setDataPosition(0);\n"+
				"ForegroundColorSpan fcs = new ForegroundColorSpan(p);";
		txtIntro.setText(intro);
	}
	
}
