package com.zixing.phil.dealing;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import com.zixing.phil.spanablestring.R;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;

public class TextAppearanceSpanDealing {
	
	public static void show(Context ctx, TextView txtResult,TextView txtIntro){
		String para1 = "青海长云暗雪山，\n";
		String para2 = "孤城遥望玉门关。\n";
		String para3 = "黄沙百战穿金甲，\n";
		String para4 = "不破楼兰终不还。";
		int l1 = para1.length(),l2 = para2.length(),l3 = para3.length(),l4 = para4.length();
		
		TextAppearanceSpan tas1 = new TextAppearanceSpan(ctx, android.R.style.TextAppearance_StatusBar_EventContent_Title);
		TextAppearanceSpan tas2 = new TextAppearanceSpan(ctx, R.style.selt_style, -1);
		TextAppearanceSpan tas3 = null;
		try {
			ColorStateList colorlist = ColorStateList.createFromXml(ctx.getResources(),ctx.getResources().getXml(R.drawable.colorlist));
			ColorStateList colorlistLink = ColorStateList.createFromXml(ctx.getResources(),ctx.getResources().getXml(R.drawable.colorlistlink));
			Typeface t = Typeface.createFromAsset(ctx.getAssets(), "fonts/fzfatfish.ttf");
			t.toString();
			tas3 = new TextAppearanceSpan("NORMAL", Typeface.BOLD_ITALIC, 20, colorlist,colorlistLink);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Parcel p = Parcel.obtain();
		p.writeString("SERIF");
		p.writeInt(Typeface.BOLD_ITALIC);
		p.writeInt(10);
		try {
			ColorStateList colorlist = ColorStateList.createFromXml(ctx.getResources(),ctx.getResources().getXml(R.drawable.parcelcolorlist));
			p.writeInt(1);
			colorlist.writeToParcel(p, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
			p.writeInt(1);
			colorlist.writeToParcel(p, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		p.setDataPosition(0);
		TextAppearanceSpan tas4 = new TextAppearanceSpan(p);
		
		Spannable spn = SpannableStringBuilder.valueOf(para1+para2+para3+para4);
		spn.setSpan(tas1, 0, l1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(tas2, l1, l1+l2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(tas3, l1+l2, l1+l2+l3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(tas4, l1+l2+l3, l1+l2+l3+l4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "TextAppearanceSpan，使用style文件来定义文本样式，该类有4个构造函数：\n" +
				"TextAppearanceSpan(Context context, int appearance)：参数context，传入的上下文，" +
				"参数appearance，引用的样式表，如R.style.my_style。\n" +
				"TextAppearanceSpan(Context context, int appearance, int colorList)：参数context，" +
				"使用的上下文，参数appearance，引用的样式表，如R.style.my_style，参数colorList，使用方式未知，" +
				"如果设置为小于0，则参数将不产生效果。\n" +
				"TextAppearanceSpan(String family, int style, int size,ColorStateList color, ColorStateList linkColor)：" +
				"参数family，字体，仅支持系统自带的三种字体，MONOSPACE、SERIF和SANS，参数style，TypeFace中定义的字体样式，BOLD、" +
				"ITALIC等，参数size，字体大小，参数color，字体颜色，参数linkColor，使用方式未知。\n" +
				"TextAppearanceSpan(Parcel src)：参数src，含有样式信息的包装类，样式信息参照5参构造。使用：\n" +
				"Parcel p = Parcel.obtain();\n"+
				"p.writeString(\"SERIF\");\n"+
				"p.writeInt(Typeface.BOLD_ITALIC);\n"+
				"p.writeInt(10);\n"+
				"try {\n"+
				"\tColorStateList colorlist = ColorStateList.createFromXml(ctx.getResources(),ctx.getResources().getXml(R.drawable.parcelcolorlist));\n"+
				"\tp.writeInt(1);\n"+
				"\tcolorlist.writeToParcel(p, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);\n"+
				"\tp.writeInt(1);\n"+
				"\tcolorlist.writeToParcel(p, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);\n"+
				"} catch (Exception e) {\n"+
				"\te.printStackTrace();\n"+
				"}\n"+
				"p.setDataPosition(0);\n"+
				"TextAppearanceSpan tas = new TextAppearanceSpan(p);\n" +
				"注：在这个设置中style似乎并未起到作用，另外关于这个类的colorList和linkColor参数的使用尚不明了，有待解答。";
		txtIntro.setText(intro);
	}
	
}
