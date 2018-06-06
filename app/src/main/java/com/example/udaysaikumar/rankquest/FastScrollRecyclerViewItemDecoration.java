package com.example.udaysaikumar.rankquest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;

/**
 * Created by udaysaikumar on 13/01/18.
 */

public class FastScrollRecyclerViewItemDecoration extends RecyclerView.ItemDecoration{
    private Context mContext;
    public FastScrollRecyclerViewItemDecoration(Context context) {
        mContext = context;
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(canvas, parent, state);

        float scaledWidth = ((FastScrollRecyclerView)parent).scaledWidth;
        float sx = ((FastScrollRecyclerView)parent).sx;
        float scaledHeight= ((FastScrollRecyclerView)parent).scaledHeight;
        float sy = ((FastScrollRecyclerView)parent).sy;
        String[] sections = ((FastScrollRecyclerView)parent).sections;
        String section = ((FastScrollRecyclerView)parent).section;
        boolean showLetter = ((FastScrollRecyclerView)parent).showLetter;

        // We draw the letter in the middle
        if (showLetter & section != null && !section.equals("")) {
            //overlay everything when displaying selected index Letter in the middle
            Paint overlayDark = new Paint();
           overlayDark.setColor(Color.TRANSPARENT);
          //overlayDark.setAlpha(100);
           // canvas.drawRect(0, 0, parent.getWidth(), parent.getHeight(),null);
            canvas.drawRect(0, 0, parent.getWidth(), parent.getHeight(), overlayDark);
           // float middleTextSize =100;

             float middleTextSize = mContext.getResources().getDimension(R.dimen.fast_scroll_overlay_text_size);
            Paint middleLetter = new Paint();
            middleLetter.setColor(Color.GRAY);
          //  middleLetter.setAlpha(100);
            //middleLetter.setColor(Color.WHITE);
            middleLetter.setTextSize(middleTextSize);
            middleLetter.setAntiAlias(true);
            middleLetter.setFakeBoldText(true);
            middleLetter.setStyle(Paint.Style.FILL);
            int xPos = (canvas.getWidth() -  (int)middleTextSize)/ 2;
            int yPos = (int) ((canvas.getHeight() / 2) - ((middleLetter.descent() + middleLetter.ascent()) / 2));
           // System.out.println(CutOffData.getSize()+"what is size 1");

switch (CutOffData.getSize()){
    case 0:
       // System.out.println("here  1");

        break;
    case 1:
       // System.out.println(" inner 1");

       // System.out.println("in draw one  1"+CutOffData.getSize());

        canvas.drawText(section.toUpperCase(), xPos, yPos, middleLetter);
break;
}
        }
        // draw indez A-Z

        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);

        for (int i = 0; i < sections.length; i++) {
            if(showLetter & section != null && !section.equals("") && section!=null
                    && sections[i].toUpperCase().equals(section.toUpperCase())) {
                textPaint.setColor(Color.RED);
               textPaint.setAlpha(250);
                textPaint.setFakeBoldText(true);
                textPaint.setTextSize((float)(scaledWidth / 2));
                //System.out.println("in sections "+sections[i]);
                //System.out.println(CutOffData.getSize()+"what is size 2");

                switch (CutOffData.getSize()){
                    case 0:
                        //System.out.println("here  2");

                        break;
                    case 1:
                       // System.out.println(" inner 2");

                       // System.out.println("in draw two 2"+CutOffData.getSize());
                        canvas.drawText(sections[i].toUpperCase(),
                                sx + textPaint.getTextSize() / 2, sy + parent.getPaddingTop()
                                        + scaledHeight * (i + 1), textPaint);
                        textPaint.setTextSize((float)(scaledWidth));
                        canvas.drawText("•",
                                sx - textPaint.getTextSize()/3, sy+parent.getPaddingTop()
                                        + scaledHeight * (i + 1) + scaledHeight/3, textPaint);
                        break;
                }


            } else {
                textPaint.setColor(Color.BLACK);
                textPaint.setAlpha(250);
                textPaint.setFakeBoldText(false);
                textPaint.setTextSize(scaledWidth / 2);
                //System.out.println(CutOffData.getSize()+"what is size 3");

                switch (CutOffData.getSize()){
                    case 0:
                       // System.out.println("here  3");
                        break;
                    case 1:
                       // System.out.println(" here 3+ inner");

                       // System.out.println("in draw draw 3"+CutOffData.getSize());

                        canvas.drawText(sections[i].toUpperCase(),
                                sx + textPaint.getTextSize() / 2, sy + parent.getPaddingTop()
                                        + scaledHeight * (i + 1), textPaint);
                        break;
                }

            }

        }




    }
}
