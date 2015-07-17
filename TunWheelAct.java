package com.tclcom.www.junit.acts;

import android.app.Activity;
import android.os.Bundle;

import com.tclcom.www.junit.JLog;
import com.tclcom.www.junit.R;
import com.tclcom.www.junit.view.TuneWheel;

/**
 * Created by sjyin on 7/15/15.
 */
public class TunWheelAct extends Activity {
    private TuneWheel wheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tun_wheel);
        initView();
    }

    private void initView() {
        wheel = (TuneWheel)findViewById(R.id.wheel);
        wheel.setValueChangeListener(new TuneWheel.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {

            }
        });
    }
}
