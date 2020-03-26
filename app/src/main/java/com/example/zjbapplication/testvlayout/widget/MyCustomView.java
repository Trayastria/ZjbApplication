package com.example.zjbapplication.testvlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.zjbapplication.R;

import androidx.annotation.Nullable;

/**
 * Created by zhaojiangbo on 2020/3/25 20:28
 * <p>
 * FUNCTION : 新建一个类，继承view，重写onMeasure()、onDraw()、layout()方法、
 * 自定义view 需要此类继承View类，需要重写onDraw(),onMeasure(),layout()三个方法;
 *      一、onDraw()方法是提供了画布的功能、其中有Canvas对象，可以调用canvas的drawXX()方法,来绘制需要的图形等，比如drawText是绘制文字，drawCircle是绘制圆形，在执行drawXX()方法的时候，Paint画笔对象是不可缺少的。
 *      二、onMeasure()方法：
 *         1、是用来测量view的宽高的方法
 *         2、其中有widthMeasureSpec和heightMesureSpac两个参数，这两个参数可以通过MesureSpec类来获取mode和size。mode有AT_MOST（最大值）和EXACTLY（准确值）和UNSPECIFIED（不准确值）三种情况，可以通过三种不       同的情况，来通过setMeasureDimension()方法，来设置view的宽高。
 *      三、TypeArray类：
 *         1、实例化：通过上下文 context.obtainStyledAttributes()方法来进行实例化，实例化需要AttributeSet和styleable对象。
 *         2、获取attrs的参数：通过TypeArray来获取xml中的layout的属性，比如颜色、宽、高等属性；
 *         3、在获取完相关属性之后，需要通过recycle()方法将其回收。
 *       四、layout()方法：计算当前view及ziview的位置
 */
public class MyCustomView extends View {
    private TextView textView;
    private Context context;

    private int mColor = Color.RED;
    private int mWidth;
    private int mHeight;

    private Paint mPaint;

    /**
     * 在java代码里 new的时候会用到
     *
     * @param context
     */
    public MyCustomView(Context context) {
        super(context);
        init(context, null);
    }

    /**
     * 在xml布局中会用到、会自动调用
     *
     * @param context
     * @param attrs
     */
    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        if (attrs != null && !isInEditMode()) {
            //加载自定义属性的集合
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
            mColor = array.getColor(R.styleable.MyCustomView_custom_color, Color.RED);
            mWidth = array.getDimensionPixelSize(R.styleable.MyCustomView_custom_width, 200);
            mHeight = array.getDimensionPixelSize(R.styleable.MyCustomView_custom_height, 200);
            //回收对象
            array.recycle();
        }
        textView = new TextView(context);
        initView();
    }

    private void initView() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);


    }

    /**
     * 用于测量View的宽高
     *
     * @param widthMeasureSpec  宽度
     * @param heightMeasureSpec 高度
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, mHeight);
        }
    }

    /**
     * 画布功能、用于视图的绘制工作
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        int radius = Math.min(width, height) / 2-10;
        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, radius, mPaint);

        textView.setText("2433");

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#000000"));
        paint.setTextSize(90f);
        canvas.drawText("123123232313", radius,radius,paint);

    }

    /**
     * 计算当前view及ziview的位置
     *
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                Log.w("MyCustomView","X: "+x+" Y: "+y);
                break;
            case MotionEvent.ACTION_UP:
                if (x + getLeft() < getRight() && y + getTop() < getBottom()) {
                    Log.w("MyCustomView","点击了");
//                    mListener.onClick(this);
//                    mViewClick.onClick(x - startX, y - startY);
                }
                break;
        }
        return true;

    }
}
