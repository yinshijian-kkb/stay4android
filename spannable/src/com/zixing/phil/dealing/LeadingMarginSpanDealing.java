package com.zixing.phil.dealing;

import android.os.Parcel;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan.Standard;
import android.widget.TextView;

public class LeadingMarginSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String s1 = "文本段落--讲述一个被人遗忘的故事......";
		String s2 = "河南的1942--悲惨的世界，无穷无尽的饥饿和死亡。";
		String s3 = "灾民的后裔，我就是当年灾民的后裔。";
		int l1 = s1.length(),l2 = s2.length(),l3 = s3.length();
		
		Parcel p = Parcel.obtain();
		p.writeInt(20);
		p.writeInt(30);
		p.setDataPosition(0);
		
		Standard lms = new Standard(p);
		Spannable spn = SpannableStringBuilder.valueOf(s1+s2+s3);
		spn.setSpan(lms, 0, l1+l2+l3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "LeadingMarginSpan.Standard，文本缩进的样式。有3个构造函数，分别为：\n" +
				"Standard(int arg0)：参数arg0，缩进的像素。\n" +
				"Standard(int arg0, int arg1)：参数arg0，首行缩进的像素，arg1，剩余行缩进的像素。\n" +
				"Standard(Parcel p)： 参数p，包含缩进信息的包装类。在构造时，\n"+
				"public Standard(Parcel src) {\n"+
				"\tmFirst = src.readInt();\n"+
				"\tmRest = src.readInt();\n"+
				"}\n" +
				"使用方式：\n" +
				"Parcel p = Parcel.obtain();\n"+
				"p.writeInt(20);\n"+
				"p.writeInt(30);\n"+
				"p.setDataPosition(0);\n" +
				"Standard lms = new Standard(p);";
		txtIntro.setText(intro);
	}
	
}
