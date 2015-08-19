package com.zixing.phil.dealing;

import android.graphics.Color;
import android.os.Parcel;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BulletSpan;
import android.widget.TextView;

public class BulletSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String p1 = "the first para.\n";
		String p2 = "the second para.\n";
		String p3 = "parcel para.";
		int l1 = p1.length(),l2 = p2.length(),l3 = p3.length();
		BulletSpan bs1 = new BulletSpan(10,Color.BLUE);
		BulletSpan bs2 = new BulletSpan();
		Parcel p = Parcel.obtain();
		p.writeInt(20);
		p.writeInt(1);
		p.writeInt(Color.YELLOW);
		p.setDataPosition(0);
		BulletSpan bs3 = new BulletSpan(p);
		
		Spannable spn = SpannableStringBuilder.valueOf(p1+p2+p3);
		spn.setSpan(bs1, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spn.setSpan(bs2, l1, l1+l2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spn.setSpan(bs3, l1+l2, l1+l2+l3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "BulletSpan，着重样式，类似于HTML中的<li>标签的圆点效果。\n" +
				"该类有4个构造函数BulletSpan()、BulletSpan(int gapWidth)、BulletSpan(int gapWidth,int color)、BulletSpan(Parcel src)。\n" +
				"BulletSpan()：仅提供一个与文本颜色一致的符号。\n" +
				"BulletSpan(int gapWidth)： 提供一个与文本颜色一致的符号，并指定符号与后面文字之间的空白长度。\n" +
				"BulletSpan(int gapWidth,int color)：提供一个指定颜色的符号，并指定符号与后面文字之间的宽度。\n" +
				"BulletSpan(Parcel src)：参数src，包含宽度、颜色信息的包装类，在以此构造时，构造函数的调用如下：" +
				"mGapWidth = src.readInt();\nmWantColor = src.readInt() != 0;\nmColor = src.readInt();\n如果使用Parcel" +
				"作为参数时，使用方式为：\nParcel p = Parcel.obtain();\n"+
				"p.writeInt(20);//设置gapWidth\n"+
				"p.writeInt(1);//设置是否使用颜色\n"+
				"p.writeInt(Color.YELLOW);//设置颜色\n"+
				"p.setDataPosition(0);\n"+
				"BulletSpan bs3 = new BulletSpan(p);";
		txtIntro.setText(intro);
	}
	
}
