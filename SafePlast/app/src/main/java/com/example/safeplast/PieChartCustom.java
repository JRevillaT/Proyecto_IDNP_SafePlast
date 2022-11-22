package com.example.safeplast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class PieChartCustom extends View {
    private float mWidth;
    private float mHeight;
    private Paint mTextPaint;
    private Paint mFigurePaint;
    private float mRadius;

    ArrayList<Plastico> listaMiConsumo;
    private final float[] mTempResult = new float[2];

    public PieChartCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mFigurePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(35f);

        Plastico.generarConsumPlasticoBeta();
        listaMiConsumo = Plastico.consumo;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // Calculate the radius from the width and height.
        mWidth = w;
        mHeight = h;
        mRadius = (float) (Math.min(mWidth, mHeight) / 2 * 0.9);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float cx = mWidth/2;
        float cy = mHeight/2;
        float startAngle = 270;
        float sweepAngle = 0;

        String str = "";
        float totalNat = totalNatalidad(listaMiConsumo);

        final float labelRadius = mRadius - 50;

        for(int i=0; i < listaMiConsumo.size(); i++){
            sweepAngle = anguloGrafico(listaMiConsumo.get(i), totalNat);
            // Drawing arcs
            mFigurePaint.setColor(Color.parseColor(listaMiConsumo.get(i).getColor()));
            canvas.drawArc(cx-mRadius,cy-mRadius,cx+mRadius,cy+mRadius,startAngle,sweepAngle,true,mFigurePaint);
            //Drawing text in the arcs
            float[] xyData = computeXYForPosition(startAngle,sweepAngle, labelRadius);
            float x = xyData[0];
            float y = xyData[1];
            str = strPorcentajeGrafico(listaMiConsumo.get(i), totalNat);
            canvas.drawText(str, 0, str.length(), x, y, mTextPaint);

            startAngle += sweepAngle;

        }

        mFigurePaint.setColor(Color.parseColor("#FFFFFF"));
        canvas.drawCircle(cx, cy, mRadius-150, mFigurePaint);
    }

    private float[] computeXYForPosition(final float startAngle, final float sweepAngle, final float radius) {
        float[] result = mTempResult;
        Double initialAngle = (startAngle + sweepAngle/2) * Math.PI/180;
        double quadrantAngle = 2 * Math.PI;
        double angle = 0.0;
        Double cosx, senx = 0.0;

        if(initialAngle < quadrantAngle){
            quadrantAngle = Math.PI * (3/2d);
            angle = initialAngle - quadrantAngle;
            cosx = Math.sin(angle);
            senx = -Math.cos(angle);
        }else {
            quadrantAngle = 2 * Math.PI;
            angle = initialAngle - quadrantAngle;
            cosx = Math.cos(angle);
            senx = Math.sin(angle);
        }

        result[0] = (float) (radius * cosx + (mWidth / 2));
        result[1] = (float) (radius * senx + (mHeight / 2));

        return result;
    }


    private float totalNatalidad(ArrayList<Plastico> p) {
        float sum = 0;
        for (Plastico e: p) {
            sum+=e.getCantidad();
        }
        return sum;
    }

    private float anguloGrafico(Plastico p, float t) {
        float ang = 0;
        ang = Math.round(p.getCantidad() * 360 / t);
        return ang;
    }

    private String strPorcentajeGrafico(Plastico p, float t) {
        int porcent = 0;
        porcent = Math.round(p.getCantidad() * 100 / t);
        return String.valueOf(porcent)+"%";
    }
}