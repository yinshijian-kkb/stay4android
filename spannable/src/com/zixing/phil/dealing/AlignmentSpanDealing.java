package com.zixing.phil.dealing;

import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan.Standard;
import android.widget.TextView;

public class AlignmentSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		Standard asCenter = new Standard(Alignment.ALIGN_CENTER);
		Standard asNormal = new Standard(Alignment.ALIGN_NORMAL);
		Standard asOpposite = new Standard(Alignment.ALIGN_OPPOSITE);
		String strCenter = "align center\n";
		String strNormal = "align normal\n";
		String strOpposite = "align opposite";
		
		int l1 = strCenter.length(),l2 = strNormal.length(),l3 = strOpposite.length();
		Spannable spn = SpannableStringBuilder.valueOf(strCenter+strNormal+strOpposite);
		spn.setSpan(asCenter, 0, l1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spn.setSpan(asNormal, l1, l1+l2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spn.setSpan(asOpposite, l1+l2, l1+l2+l3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro="AlignmentSpan.Standard，标准文本对齐样式，该类有两个构造函数，AlignmentSpan.Standard(Layout.Alignment align)和" +
				"AlignmentSpan.Standard(Parcel src)。\nAlignmentSpan.Standard(Layout.Alignment align)：参数align，Layout.Alignment类型的枚举值。" +
				"包括居中、正常和相反三种情况。\n" +
				"AlignmentSpan.Standard(Parcel src)：参数src，包含有标准字符串的Parcel类，其值应为\"ALIGN_CENTER\"、\"ALIGN_NORMAL\"或\"ALIGN_OPPOSITE\"中的之一，" +
				"对应Layout.Alignment枚举中的三个类型。使用示例：\n" +
				"Parcel p = Parcel.obtain();\n"+
				"p.writeString(\"ALIGN_CENTER\");\n"+
				"p.setDataPosition(0);\n" +
				"AlignmentSpan.Standard standard = new AlignmentSpan.Standard(p);";
		txtIntro.setText(intro);
	}
	
}
