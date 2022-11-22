package com.example.safeplast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Leyend_PieChart extends View{
    private float mWidth;                   // Custom view width.
    private float mHeight;                  // Custom view height.
    private Paint mTextPaint;               // For text in the view.
    private Paint mFigurePaint;               // For dial circle in the view.

    ArrayList<Plastico> listaMiConsumo;

    public Leyend_PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mFigurePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(35f);

        listaMiConsumo = Plastico.consumo;


    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // Calculate the radius from the width and height.
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float x = mWidth/4;
        float y = mHeight/8;
        float ancho = 20;

        String str = "";

        for(int i=0; i < listaMiConsumo.size(); i++){

            mFigurePaint.setColor(Color.parseColor(listaMiConsumo.get(i).getColor()));
            canvas.drawRect(x-ancho,y-ancho,x+ancho,y+ancho,mFigurePaint);

            str = listaMiConsumo.get(i).getNombre();
            canvas.drawText(str, 0, str.length(), x+120, y+10, mTextPaint);

            y+=60;
        }
    }
}
