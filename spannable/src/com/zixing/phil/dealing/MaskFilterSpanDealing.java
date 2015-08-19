package com.zixing.phil.dealing;

import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.MaskFilterSpan;
import android.widget.TextView;

public class MaskFilterSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String s1 = "MaskFilterSpan";
		String s2 =	"究竟应该如何使用？";
		int l1 = s1.length(),l2 = s2.length();
		
		MaskFilter mfBlur = new BlurMaskFilter(4,Blur.OUTER);
		MaskFilter mfEmboss = new EmbossMaskFilter(new float[]{10,10,10}, 0.5f, 8f, 3f);
		
		MaskFilterSpan mfsBlur = new MaskFilterSpan(mfBlur);
		MaskFilterSpan mfsEmboss = new MaskFilterSpan(mfEmboss);
		Spannable spn = SpannableStringBuilder.valueOf(s1+s2);
		spn.setSpan(mfsBlur, 0, l1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		spn.setSpan(mfsEmboss, l1, l1+l2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setTextSize(30);
		txtResult.setText(spn);
		
		String intro = "MaskFilterSpan，滤镜样式，只有一个构造函数：\n" +
				"MaskFilterSpan(MaskFilter filter)：参数filter，滤镜样式。\n" +
				"说明：\n" +
				"在android系统里，MaskFilter提供了两个子类，BlurMaskFilter和EmbossMaskFilter，分别用来制作" +
				"模糊效果和立体效果。";
		txtIntro.setText(intro);
	}
	
}
