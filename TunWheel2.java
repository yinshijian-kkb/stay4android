package com.example.zhangquan.myapplication;

import android.widget.Scroller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * 原文连接 : http://blog.csdn.net/ttdevs/article/details/38944799
 * 作者：ttdevs
 *
 * 卷尺控件类。由于时间比较紧，只有下班后有时间，因此只实现了基本功能。<br>
 * 细节问题包括滑动过程中widget边缘的刻度显示问题等<br>
 * <p/>
 * 周末有时间会继续更新<br>
 *
 *
 * @author ttdevs
 * @version create：2014年8月26日
 */
@SuppressLint("ClickableViewAccessibility")
public class TunWheel2 extends View {

    public interface OnValueChangeListener {
        public void onValueChange(float value);
    }

    public static final int MOD_TYPE_HALF = 5;//小刻度的个数
    public static final int MOD_TYPE_ONE = 20;

    private static final int ITEM_HALF_DIVIDER = 15;//每个刻度的大小
    private static final int ITEM_ONE_DIVIDER = 10;

    private static final int ITEM_MAX_HEIGHT = 50;
    private static final int ITEM_MIN_HEIGHT = 20;

    private static final int TEXT_SIZE = 18;

    private float mDensity;

    //当前的刻度值
    private int mStep = 125, mMaxValue = 250, mModType = MOD_TYPE_HALF, mLineDivider = ITEM_HALF_DIVIDER;

    private int mLastX, mMove;
    private int mWidth, mHeight;

    private int mMinVelocity;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;

    private OnValueChangeListener mListener;

    @SuppressWarnings("deprecation")
    public TunWheel2(Context context, AttributeSet attrs) {
        super(context, attrs);

        mScroller = new Scroller(getContext());
        mDensity = getContext().getResources().getDisplayMetrics().density;

        mMinVelocity = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();

        // setBackgroundResource(R.drawable.bg_wheel);
        setBackgroundDrawable(createBackground());
    }

    private GradientDrawable createBackground() {
        float strokeWidth = 4 * mDensity; // 边框宽度
        float roundRadius = 6 * mDensity; // 圆角半径
        int strokeColor = Color.parseColor("#FF666666");// 边框颜色
        // int fillColor = Color.parseColor("#DFDFE0");// 内部填充颜色

        setPadding((int) strokeWidth, (int) strokeWidth, (int) strokeWidth, 0);

        int colors[] = {0xFF999999, 0xFFFFFFFF, 0xFF999999};// 分别为开始颜色，中间夜色，结束颜色
        GradientDrawable bgDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);// 创建drawable
        // bgDrawable.setColor(fillColor);
        bgDrawable.setCornerRadius(roundRadius);
        bgDrawable.setStroke((int) strokeWidth, strokeColor);
        // setBackgroundDrawable(gd);
        return bgDrawable;
    }

    /**
     * 设置用于接收结果的监听器
     *
     * @param listener
     */
    public void setValueChangeListener(OnValueChangeListener listener) {
        mListener = listener;
    }

    /**
     * 获取当前刻度值
     *
     * @return
     */
    public float getValue() {
        return mStep;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        mWidth = getWidth();
        mHeight = getHeight();
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawScaleLine(canvas);
        drawWheel(canvas);
        drawMiddleLine(canvas);
    }

    private void drawWheel(Canvas canvas) {
        Drawable wheel = getResources().getDrawable(R.drawable.bg_wheel);
        wheel.setBounds(0, 0, getWidth(), getHeight());
        wheel.draw(canvas);
    }

    /**
     * 从中间往两边开始画刻度线
     *
     * @param canvas
     */
    private void drawScaleLine(Canvas canvas) {
        canvas.save();
        JLog.e("------mStep: " + mStep);

        Paint linePaint = new Paint();
        linePaint.setStrokeWidth(2);
        linePaint.setColor(Color.BLACK);

        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(TEXT_SIZE * mDensity);//px 2 dp

        int width = mWidth, drawCount = 0;
        float xPosition, textWidth = Layout.getDesiredWidth("0", textPaint);
        for (int i = 0; drawCount <= 10 * width; i++) {//i 表示一个刻度
            xPosition = (width / 2 - mMove) + i * mLineDivider * mDensity;
            if (xPosition + getPaddingRight() < mWidth) {//右侧刻度
                if ((mStep + i) % mModType == 0) {//长刻度
                    canvas.drawLine(xPosition, mHeight, xPosition, mHeight / 2, linePaint);
                    if (mStep + i <= mMaxValue) {
                        canvas.drawText(String.valueOf((mStep + i) * 200), countLeftStart(mStep + i, xPosition, textWidth), mHeight / 2, textPaint);
                    }
                } else {//短刻度
                    canvas.drawLine(xPosition, xPosition, xPosition, mDensity * ITEM_MAX_HEIGHT, linePaint);
                }
            }

            xPosition = (width / 2 - mMove) - i * mLineDivider * mDensity;
            if (xPosition > getPaddingLeft()) {//左侧刻度
                if ((mStep - i) % mModType == 0) {//长刻度
                    canvas.drawLine(xPosition, mHeight, xPosition, mHeight / 2, linePaint);
                    if (mStep - i >= 0) {
                        canvas.drawText(String.valueOf((mStep - i) * 200), countLeftStart(mStep - i, xPosition, textWidth), mHeight / 2, textPaint);
                    }
                } else {//短刻度
                    canvas.drawLine(xPosition, mHeight, xPosition, mDensity * ITEM_MAX_HEIGHT, linePaint);
                }
            }

            drawCount += 2 * mLineDivider * mDensity;
        }

        canvas.restore();
    }

    /**
     * 计算没有数字显示位置的辅助方法
     *
     * @param value
     * @param xPosition
     * @param textWidth
     * @return
     */
    private float countLeftStart(int value, float xPosition, float textWidth) {
        float xp;
        if (value < 20) {
            xp = xPosition - (textWidth * 1 / 2);
        } else {
            xp = xPosition - (textWidth * 2 / 2);
        }
        return xp;
    }

    /**
     * 画中间的蓝色指示线
     *
     * @param canvas
     */
    private void drawMiddleLine(Canvas canvas) {
        int indexWidth = 8;

        canvas.save();

        Paint redPaint = new Paint();
        redPaint.setStrokeWidth(indexWidth);
        redPaint.setColor(Color.BLUE);
        canvas.drawLine(mWidth / 2, mHeight / 2, mWidth / 2, mHeight, redPaint);

        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int xPosition = (int) event.getRawX();

        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);

        switch (action) {
            case MotionEvent.ACTION_DOWN:

                mScroller.forceFinished(true);

                mLastX = (int) event.getRawX();
                mMove = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                mMove += (mLastX - xPosition);//每次回调移动的距离
                changeMoveAndValue();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
//                countMoveEnd();
                countVelocityTracker(event);
                countMoveEnd2();
                return false;
            default:
                break;
        }

        mLastX = xPosition;
        return true;
    }

    /**
     * 用户滑动后的惯性动画
     * @param event
     */
    private void countVelocityTracker(MotionEvent event) {
        mVelocityTracker.computeCurrentVelocity(1000);
        float xVelocity = mVelocityTracker.getXVelocity();
        if (Math.abs(xVelocity) > mMinVelocity) {
            mScroller.fling(0, 0, (int) xVelocity, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);//会触发computeScroll
        }
    }

    private void changeMoveAndValue() {
        int tValue = (int) (mMove / (mLineDivider * mDensity));//cur move step
        if (Math.abs(tValue) > 0) {
            mStep += tValue;
            mMove -= tValue * mLineDivider * mDensity;//为什么要减少呢 —— [0,30)刻度
            if (mStep <= 0 || mStep > mMaxValue) {
                mStep = mStep <= 0 ? 0 : mMaxValue;
                mMove = 0;
                mScroller.forceFinished(true);
            }
            notifyValueChange();
        }
        postInvalidate();
    }

    private void countMoveEnd() {
        int roundMove = Math.round(mMove / (mLineDivider * mDensity));
        mStep = mStep + roundMove;
        mStep = mStep <= 0 ? 0 : mStep;
        mStep = mStep > mMaxValue ? mMaxValue : mStep;

        mLastX = 0;
        mMove = 0;

        notifyValueChange();
        postInvalidate();
    }

    private void notifyValueChange() {
        if (null != mListener) {
            if (mModType == MOD_TYPE_HALF) {
                mListener.onValueChange(mStep*200 / 2f);
            }
        }
    }

    /**
     * 指针停留在长刻度
     */
    private void countMoveEnd2() {
        int tempStep = mStep;
        int delta = (5 - tempStep % 5);
        /*
        就近算法：
        就用最简单的方法好了（我觉得也是效率最高的）：
        每次取一个数和它做差，如果差绝对值小于以前比出来的最小差，则将该最小差换为现在这个，
        最接近数也换为现在这个，这样，该数组遍历一遍，即可找出最接近数。
         */
        int max = Math.max(tempStep % 5, delta);
        if (max == tempStep % 5) {
            tempStep = tempStep + delta;
        } else {
            tempStep = tempStep - tempStep % 5;
        }

        mStep = tempStep;

        mLastX = 0;
        mMove = 0;
        postInvalidate();

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {//scroller动画中
            if (mScroller.getCurrX() == mScroller.getFinalX()) { // over
//                countMoveEnd();
                countMoveEnd2();
            } else {
                int xPosition = mScroller.getCurrX();
                mMove += (mLastX - xPosition);
                changeMoveAndValue();
                mLastX = xPosition;
            }
        }
    }
}

