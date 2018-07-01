package com.example.aaron.test.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.aaron.test.PlayManuallyActivity;

/**
 * Handles maze graphics.
 */
public class MazePanel extends View {
    // TODO: please check 
    // https://developer.android.com/training/custom-views/create-view
    // https://developer.android.com/training/custom-views/custom-drawing
    // on how to implement your own View class
    private Canvas C = new Canvas(PlayManuallyActivity.B);
    /**
     * Constructor with one context parameter.
     * @param context
     */
    public MazePanel(Context context) {
        super(context);

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
        super.onDraw(c);
	    C.drawBitmap(PlayManuallyActivity.B,null,null);
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

    }

    /**
     * Sets paint object color attribute to given color.
     * @param color
     */
    public void setColor(int color) {
	// TODO: set the current color
    }
    
    /**
     * Takes in color integer values [0-255], returns corresponding color-int value. 
     * @param red
     * @param green
     * @param blue
     */
    public static int getColorEncoding(int red, int green, int blue) {
	// TODO: provide rgb color encoding
        Color.rgb(red, green, blue);
        return (255 & 0xff) << 24 | (red & 0xff) << 16 | (green & 0xff) << 8 | (blue & 0xff);
    }
    
    /**
     * Returns the RGB value representing the current color. 
     * @return integer RGB value
     */
    public int getColor() {
	// TODO return the current color setting
        return 0;
    }
    
    /**
     * Takes in rectangle params, fills rectangle in canvas based on these. 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void fillRect(int x, int y, int width, int height) {
        C.drawRect(x, y, x+width, y+height, null);
    }
    
    /**
     * Takes in polygon params, fills polygon in canvas based on these. 
     * Paint is always that for corn.
     * @param xPoints
     * @param yPoints
     * @param nPoints
     */
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints){
        // translate the points into a path
        // draw a path on the canvas
    }
    
    /**
     * Takes in line params, draws line in canvas based on these. 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        C.drawLine(x1, x2, y1, y2, null);
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
