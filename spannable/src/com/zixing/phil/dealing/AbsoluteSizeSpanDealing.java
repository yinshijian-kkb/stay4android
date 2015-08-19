package com.zixing.phil.dealing;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

public class AbsoluteSizeSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String standard = "标准字体";
		String big = "25px字体";
		String small = "10px字体";
		
		Spannable spn = SpannableStringBuilder.valueOf(small+standard+big);
		AbsoluteSizeSpan ass25 = new AbsoluteSizeSpan(25);
		AbsoluteSizeSpan ass10 = new AbsoluteSizeSpan(10);
		spn.setSpan(ass10, 0, small.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spn.setSpan(ass25, small.length()+standard.length(), small.length()+standard.length()+big.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);

		String intro ="顾名思义，AbsoluteSizeSpan是指绝对尺寸，通过指定绝对尺寸来改变文本的字体大小。\n该类有三个构造函数：\n" +
				"AbsoluteSizeSpan(int size)、AbsoluteSizeSpan(int size, boolean dip)、AbsoluteSizeSpan(Parcel src)。\n" +
				"AbsoluteSizeSpan(int size)：参数size，Set the text size to size physical pixels. 以size的指定的像素值来设定文本大小。\n" +
				"AbsoluteSizeSpan(int size, boolean dip)：参数size，Set the text size to size physical pixels, or to size device-independent pixels if dip is true." +
				"以size的指定像素值来设定文本大小，如果参数dip为true则以size指定的dip为值来设定文本大小。\n" +
				"AbsoluteSizeSpan(Parcel src)：参数src，包含有size和dip值的包装类。在该构造中\n"+
				"public AbsoluteSizeSpan(Parcel src) {\n"+
				"\tmSize = src.readInt();\n"+
				"\tmDip = src.readInt() != 0;\n"+
				"}\n使用范例：\nParcel p = Parcel.obtain();\n"+
				"p.writeInt(29);//字体大小\n"+
				"p.writeInt(8);//是否是dip单位\n"+
				"p.setDataPosition(0);\n"+
				"AbsoluteSizeSpan ass = new AbsoluteSizeSpan(p);";
		txtIntro.setText(intro);
	}
	
}
