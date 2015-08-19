package com.zixing.phil.dealing;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

public class BackgroundColorSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String strBgBlue = "蓝色背景";
		String strBgGray = "灰色背景";
		String strBgYellow = "黄色背景";
		int l1 = strBgBlue.length(),l2 = strBgGray.length(),l3 = strBgYellow.length();
		
		BackgroundColorSpan bcsBlue = new BackgroundColorSpan(Color.BLUE);
		BackgroundColorSpan bcsGray = new BackgroundColorSpan(Color.GRAY);
		BackgroundColorSpan bcsYellow = new BackgroundColorSpan(Color.YELLOW);
		Spannable spn = SpannableStringBuilder.valueOf(strBgBlue+strBgGray+strBgYellow);
		spn.setSpan(bcsBlue, 0, l1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spn.setSpan(bcsGray, l1, l1+l2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spn.setSpan(bcsYellow, l1+l2, l1+l2+l3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "BackgroundColorSpan，背景色样式，显然可以用来设定文本的背景色。该类有两个构造函数，" +
				"BackgroundColorSpan(int color)和BackgroundColorSpan(Parcel src)。\n" +
				"BackgroundColorSpan(int color)：参数color，颜色值。\n" +
				"BackgroundColorSpan(Parcel src)：参数src，包含颜色值信息的包装类，使用方法如下:\n" +
				"Parcel p = Parcel.obtain();\np.writeInt(Color.GREEN);\np.setDataPosition(0);\n" +
				"BackgroundColorSpan bcs = new BackgroundColorSpan(p);";
		txtIntro.setText(intro);
	}
	
}
