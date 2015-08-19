package com.zixing.phil.dealing;

import com.zixing.phil.spanablestring.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;

public class ImageSpanDealing {
	
	public static void show(Context ctx,TextView txtResult,TextView txtIntro){
		String text = "Android*一词的本义*指“机器人”*。Google*";
		Bitmap bm = ((BitmapDrawable)ctx.getResources().getDrawable(R.drawable.joke)).getBitmap();
		Drawable d = ctx.getResources().getDrawable(R.drawable.dollar);
		d.setBounds(0, 0, (int)txtResult.getTextSize(),  (int)txtResult.getTextSize());
		Uri uri = Uri.parse("android.resource://"+ctx.getPackageName()+"/"+R.drawable.flower);

		ImageSpan is1 = new ImageSpan(ctx,bm,ImageSpan.ALIGN_BASELINE);
		ImageSpan is2 = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
		ImageSpan is3 = new ImageSpan(ctx, R.drawable.ic_launcher);
		ImageSpan is4 = new ImageSpan(ctx, uri,ImageSpan.ALIGN_BASELINE);
		Spannable spn = SpannableStringBuilder.valueOf(text);
		spn.setSpan(is1, 7, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(is2, 13, 14, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		spn.setSpan(is3, 20, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spn.setSpan(is4, 28, 29, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		txtResult.setText(spn);
		
		String intro = "ImageSpan，图片样式，主要用于在文本中插入图片。本类构造函数较多，" +
				"但主要是针对Bitmap和Drawable的，也可以通过资源Id直接加载图片。简介如下：\n" +
				"ImageSpan(Bitmap b)： This constructor is deprecated. Use ImageSpan(Context, Bitmap)" +
				" instead.参数b，用于显示的Bitmap。该方法已过时，改用Use ImageSpan(Context, Bitmap)代替。\n"+
				"ImageSpan(Bitmap b, int verticalAlignment)： This constructor is deprecated. Use ImageSpan" +
				"(Context, Bitmap, int) instead.参数b，用于显示的Bitmap，参数verticalAlignment，对齐方式，对应" +
				"ImageSpan中的常量值。该方法已过时，改用ImageSpan(Context, Bitmap, int)代替。\n"+
				"ImageSpan(Context context, Bitmap b)：参数context，传入的上下文，参数b，用于显示的Bitmap。\n"+
				"ImageSpan(Context context, Bitmap b, int verticalAlignment)：参数context，传入的上下文，参数b，用于" +
				"显示的Bitmap，参数verticalAlignment，对齐方式。\n"+
				"ImageSpan(Drawable d)：参数d，用于显示的Drawable，此Drawable须设置大小。\n"+
				"ImageSpan(Drawable d, int verticalAlignment)：参数d，用于显示的Drawable，参数verticalAlignment，对齐方式。\n"+
				"ImageSpan(Drawable d, String source)：参数d，用于显示的Drawable，参数source，资源字符串。\n"+
				"ImageSpan(Drawable d, String source, int verticalAlignment)：参数d，用于显示的Drawable，参数source，资源字符串，" +
				"参数verticalAlignment，对齐方式。\n"+
				"ImageSpan(Context context, Uri uri)：参数context，传入的上下文，参数uri，图片的uri。\n"+
				"ImageSpan(Context context, Uri uri, int verticalAlignment)：参数context，传入的上下文，参数uri，图片的uri" +
				"，参数verticalAlignment，对齐方式。\n"+
				"ImageSpan(Context context, int resourceId)：参数context，传入的上下文，参数resourceId，图片的资源id。\n"+
				"ImageSpan(Context context, int resourceId, int verticalAlignment)参数context，传入的上下文，参数resourceId，" +
				"图片的资源id，参数verticalAlignment，对齐方式。";
		txtIntro.setText(intro);
	}
	
}
