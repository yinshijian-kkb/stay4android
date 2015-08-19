package com.zixing.phil.dealing;

import com.zixing.phil.spanablestring.R;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.DrawableMarginSpan;
import android.widget.TextView;

public class DrawableMarginSpanDealing {
	
	public static void show(Context ctx,TextView txtResult,TextView txtIntro){
		String strStart = "no pad text\n";
		String strMiddle = "pad 30px text\n";
		String strEnd = "pad 10px text";
		int l1 = strStart.length(),l2 = strMiddle.length(),l3 = strEnd.length();
		DrawableMarginSpan dms = new DrawableMarginSpan(ctx.getResources().getDrawable(R.drawable.joke));
		DrawableMarginSpan dmsMargin = new DrawableMarginSpan(ctx.getResources().getDrawable(R.drawable.flower), 30);
		DrawableMarginSpan dmsBottom = new DrawableMarginSpan(ctx.getResources().getDrawable(R.drawable.ic_launcher),10);
		Spannable spn = SpannableStringBuilder.valueOf(strStart+strMiddle+strEnd);
		spn.setSpan(dms, 0, l1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		spn.setSpan(dmsMargin, l1, l1+l2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		spn.setSpan(dmsBottom, l1+l2, l1+l2+l3, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "DrawableMarginSpan，图片+Margin样式，该类有两个构造函数：\nDrawableMarginSpan(Drawable b)、\n" +
				"DrawableMarginSpan(Drawable b,int pad)\n" +
				"DrawableMarginSpan(Drawable b)：参数b，用于显示的图片。\n" +
				"DrawableMarginSpan(Drawable b,int pad)：参数b，用于显示的图片，参数pad，图片和文字的距离。\n" +
				"说明：\n在setSpan时，注意此设置只对参数start和end之间的文本有作用，如果不使用换行符做适当分割，则容易产生文字和图片" +
				"相重叠的现象。";
		txtIntro.setText(intro);
	}
	
}
