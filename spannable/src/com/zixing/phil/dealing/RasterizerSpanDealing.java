package com.zixing.phil.dealing;

import android.graphics.Color;
import android.graphics.LayerRasterizer;
import android.graphics.Paint;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RasterizerSpan;
import android.widget.TextView;

public class RasterizerSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String paragraph = "臣亮表：先帝创业未半而中道崩殂，今天下三分，益州疲弊，" +
				"此诚危急存亡之秋也。然侍卫之臣不懈于内， 忠志之士忘身于外者，盖追" +
				"先帝之殊遇，欲报之于陛下也";
		int l1 = paragraph.length();
		
		Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
		p.setColor(Color.BLUE);
		LayerRasterizer rasterizer = new LayerRasterizer();
		rasterizer.addLayer(p);
		RasterizerSpan rs = new RasterizerSpan(rasterizer);
		Spannable spn = SpannableStringBuilder.valueOf(paragraph);
		spn.setSpan(rs, 0, l1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "RasterizerSpan，字面义为光栅化，实际效果不明显，待完善。一个构造函数：\n" +
				"RasterizerSpan(Rasterizer r)：\n" +
				"Rasterizer只有一个系统定义了的子类LayerRasterizer。";
		txtIntro.setText(intro);
	}
	
}
