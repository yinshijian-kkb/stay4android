package com.zixing.phil.spanablestring;

import com.zixing.phil.dealing.AbsoluteSizeSpanDealing;
import com.zixing.phil.dealing.AlignmentSpanDealing;
import com.zixing.phil.dealing.BackgroundColorSpanDealing;
import com.zixing.phil.dealing.BulletSpanDealing;
import com.zixing.phil.dealing.DrawableMarginSpanDealing;
import com.zixing.phil.dealing.ForegroundColorSpanDealing;
import com.zixing.phil.dealing.IconMarginSpanDealing;
import com.zixing.phil.dealing.ImageSpanDealing;
import com.zixing.phil.dealing.LeadingMarginSpanDealing;
import com.zixing.phil.dealing.MaskFilterSpanDealing;
import com.zixing.phil.dealing.QuoteSpanDealing;
import com.zixing.phil.dealing.RasterizerSpanDealing;
import com.zixing.phil.dealing.RelativeSizeSpanDealing;
import com.zixing.phil.dealing.ScaleXSpanDealing;
import com.zixing.phil.dealing.StrikethroughSpanDealing;
import com.zixing.phil.dealing.StyleSpanDealing;
import com.zixing.phil.dealing.SubscriptSpanDealing;
import com.zixing.phil.dealing.SuperscriptSpanDealing;
import com.zixing.phil.dealing.TabStopSpanDealing;
import com.zixing.phil.dealing.TextAppearanceSpanDealing;
import com.zixing.phil.dealing.TypefaceSpanDealing;
import com.zixing.phil.dealing.URLSpanDealing;
import com.zixing.phil.dealing.UnderlineSpanDealing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EffectActivity extends Activity {

	private TextView txtResult;
	private TextView txtIntro;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.effect);
		init();
	}

	private void init() {
		txtResult = (TextView) findViewById(R.id.txt_result);
		txtIntro = (TextView) findViewById(R.id.txt_intro);
		int styleIndex = getIntent().getIntExtra(Styles.STYLE_INDEX, -1);
		switch (styleIndex) {
		case 0:
			AbsoluteSizeSpanDealing.show(txtResult, txtIntro);
			break;
		case 1:
			AlignmentSpanDealing.show(txtResult, txtIntro);
			break;
		case 2:
			BackgroundColorSpanDealing.show(txtResult, txtIntro);
			break;
		case 3:
			BulletSpanDealing.show(txtResult, txtIntro);
			break;
		case 4:
			DrawableMarginSpanDealing.show(EffectActivity.this,txtResult, txtIntro);
			break;
		case 5:
			ForegroundColorSpanDealing.show(txtResult, txtIntro);
			break;
		case 6:
			IconMarginSpanDealing.show(EffectActivity.this, txtResult, txtIntro);
			break;
		case 7:
			ImageSpanDealing.show(EffectActivity.this, txtResult, txtIntro);
			break;
		case 8:
			LeadingMarginSpanDealing.show(txtResult, txtIntro);
			break;
		case 9:
			MaskFilterSpanDealing.show(txtResult, txtIntro);
			break;
		case 10:
			QuoteSpanDealing.show(txtResult, txtIntro);
			break;
		case 11:
			RasterizerSpanDealing.show(txtResult, txtIntro);
			break;
		case 12:
			RelativeSizeSpanDealing.show(txtResult, txtIntro);
			break;
		case 13:
			ScaleXSpanDealing.show(txtResult, txtIntro);
			break;
		case 14:
			StrikethroughSpanDealing.show(txtResult, txtIntro);
			break;
		case 15:
			StyleSpanDealing.show(txtResult, txtIntro);
			break;
		case 16:
			SubscriptSpanDealing.show(txtResult, txtIntro);
			break;
		case 17:
			SuperscriptSpanDealing.show(txtResult, txtIntro);
			break;
		case 18:
			TabStopSpanDealing.show(txtResult, txtIntro);
			break;
		case 19:
			TextAppearanceSpanDealing.show(EffectActivity.this,txtResult, txtIntro);
			break;
		case 20:
			TypefaceSpanDealing.show(EffectActivity.this, txtResult, txtIntro);
			break;
		case 21:
			UnderlineSpanDealing.show(txtResult, txtIntro);
			break;
		case 22:
			URLSpanDealing.show(txtResult, txtIntro);
			break;
		default:
			break;
		}
	}
	
}
