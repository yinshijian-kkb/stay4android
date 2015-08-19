package com.zixing.phil.dealing;

import com.zixing.phil.spanablestring.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.IconMarginSpan;
import android.widget.TextView;

public class IconMarginSpanDealing {
	
	public static void show(Context ctx,TextView txtResult,TextView txtIntro){
		String str1 = "第一行文本\n";
		String str2 = "第二行文本\n";
		String str3 = "第三行文本";
		int l1 = str1.length(),l2 = str2.length(),l3 = str3.length();
		
		Bitmap bmJoke = ((BitmapDrawable)ctx.getResources().getDrawable(R.drawable.joke)).getBitmap();
		IconMarginSpan imsFirst = new IconMarginSpan(bmJoke);
		Bitmap bmFlower = ((BitmapDrawable)ctx.getResources().getDrawable(R.drawable.flower)).getBitmap();
		IconMarginSpan imsSecond = new IconMarginSpan(bmFlower, 30);
		Spannable spn = SpannableStringBuilder.valueOf(str1+str2+str3);
		spn.setSpan(imsFirst, l1, l1+l2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		spn.setSpan(imsSecond, l1+l2, l1+l2+l3, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "IconMarginSpan，图标+Margin样式，该类与DrawableMarginSpan使用上很相似。本类有两个构造函数：\n" +
				"IconMarginSpan(Bitmap b)：参数b，用于显示图像的bitmap。\n" +
				"IconMarginSpan(Bitmap b,int pad)：参数b，用于显示图像的bitmap，参数pad，Bitmap和文本之间的间距。";
		txtIntro.setText(intro);
	}
	
}
