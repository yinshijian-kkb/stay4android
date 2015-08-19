package com.zixing.phil.dealing;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.TabStopSpan.Standard;
import android.widget.TextView;

public class TabStopSpanDealing {
	
	public static void show(TextView txtResult,TextView txtIntro){
		String para1 = "\t(本段偏移50)北冥有鱼，\t其名为鲲。鲲之大，不知其几千里也。化而为鸟，其名为鹏。\r\n";
		String para2 = "\t(本段未偏移)鹏之背，不知\t其几千里也；怒而飞，其翼若垂天之云。是鸟也，海运则将徙于南冥。" +
				"南冥者，天池也。 ";
		
		Standard tss = new Standard(50);
		Spannable spn = SpannableStringBuilder.valueOf(para1+para2);
		spn.setSpan(tss, 0, para1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "TabStopSpan.Standard，制表位偏移样式，距离每行的leading margin的偏移量，据测试在首行加入\\t时" +
				"才产生效果。构造函数：\n" +
				"TabStopSpan.Standard(int where)：参数where，偏移量。";
		txtIntro.setText(intro);
	}
	
}
