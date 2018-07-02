package com.example.aaron.test.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Handles maze graphics.
 */
public class MazePanel extends View {
    // TODO: please check 
    // https://developer.android.com/training/custom-views/create-view
    // https://developer.android.com/training/custom-views/custom-drawing
    // on how to implement your own View class
    private int CurColor;
    private Paint P = new Paint();
    private Bitmap B = Bitmap.createBitmap(300,300,Bitmap.Config.ARGB_8888);
    private Canvas C = new Canvas(B);
    /**
     * Constructor with one context parameter.
     * @param context
     */
    public MazePanel(Context context) {
        super(context);
        P.setStyle(Paint.Style.FILL);
        // call super class constructor as necessary
	// TODO: initialize instance variables as necessary
    }
    /**
     * Constructor with two parameters: context and attributes.
     * @param context
     * @param app
     */
    public MazePanel(Context context, AttributeSet app) {
        super(context, app);
        P.setStyle(Paint.Style.FILL);
        // call super class constructor as necessary
	// TODO: initialize instance variables as necessary
    }
    public void setCanvas(Canvas C){
        this.C = C;
    }
    /**
     * Draws given canvas.
     * @param c
     */
    @Override
	public void onDraw(Canvas c) {
	    c.drawBitmap(B,new Matrix(),P);
    }
    
    /**
     * Measures the view and its content to determine the measured width and the measured height.
     * @param width
     * @param height
     */
    @Override
    public void onMeasure(int width, int height) {
        super.onMeasure(width, height);
    }
    
    /**
     * Updates maze graphics.
     */
    public void update() {
	//TODO: update maze graphics
    }
    
    /**
     * Takes in ColorTheme, sets paint color to corresponding color.
     * @param CT
     */
    public void setColor(ColorTheme CT) {
        CurColor = CT.getColorCode();
        P.setColor(CurColor);
    }

    /**
     * Sets paint object color attribute to given color.
     * @param color
     */
    public void setColor(int color) {
        CurColor = color;
        P.setColor(color);
    }
    
    /**
     * Takes in color integer values [0-255], returns corresponding color-int value. 
     * @param red
     * @param green
     * @param blue
     */
    public static int getColorEncoding(int red, int green, int blue) {
	// TODO: provide rgb color encoding
        return Color.rgb(red, green, blue);
        //return (255 & 0xff) << 24 | (red & 0xff) << 16 | (green & 0xff) << 8 | (blue & 0xff);
    }
    
    /**
     * Returns the RGB value representing the current color. 
     * @return integer RGB value
     */
    public int getColor() {
	// TODO return the current color setting
        return CurColor;
    }
    
    /**
     * Takes in rectangle params, fills rectangle in canvas based on these. 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void fillRect(int x, int y, int width, int height) {
        C.drawRect(x, y, width, height, P);
    }
    
    /**
     * Takes in polygon params, fills polygon in canvas based on these. 
     * Paint is always that for corn.
     * @param xPoints
     * @param yPoints
     * @param nPoints
     */
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints){
        Path P = new Path();
        P.lineTo(xPoints[0], xPoints[1]);
        P.close();
    }
    
    /**
     * Takes in line params, draws line in canvas based on these. 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        C.drawLine(x1, y1, x2, y2, P);
    }
    
    /**
     * Takes in oval params, fills oval in canvas based on these. 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void fillOval(int x, int y, int width, int height) {
	// TODO: draw an oval on the canvas
    }
}
