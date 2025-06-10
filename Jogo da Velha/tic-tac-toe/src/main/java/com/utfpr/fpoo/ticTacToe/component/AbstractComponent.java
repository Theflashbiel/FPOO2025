package com.utfpr.fpoo.ticTacToe.component;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;



import com.utfpr.fpoo.ticTacToe.gui.Paintable;
import com.utfpr.fpoo.ticTacToe.gui.util.MouseListenerAdapter;

public abstract class AbstractComponent implements Paintable{
    
    protected Point position;
    protected Dimension dimension;
    protected boolean mouseOver = false;
    public AbstractComponent() {
        this.position = new Point(0, 0);
        this.dimension = new Dimension(100, 100);
    }
    public AbstractComponent(int x, int y) {
        this();
        this.position = new Point(x, y);
    }

    public AbstractComponent(int x, int y, int width, int height) {
        this(x, y);
        this.dimension = new Dimension(width, height);
    }
    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }
    public Point getPosition() {
        return position;
    }
    public Dimension getSize() {
        return dimension;
    }
    public void setSize(int width, int height) {
        this.dimension = new Dimension();
    }
    public int width(){
        return this.dimension.width;
    }
    public int height(){
        return this.dimension.height;
    }
public MouseListener mouseListener() {
	
		return new MouseListenerAdapter() {
	
	
			public void mouseClicked( MouseEvent me ) {
				
				if(isOver( me.getPoint()))
				   onMouseClick(me);
				}
			};

	}
	public MouseMotionListener mouseMotionListener() {
        return new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                boolean inside = isOver(e.getPoint());
                if (inside != mouseOver) {
                    mouseOver = inside;
                    e.getComponent().repaint(); 
                }
            }
        };
    }
    public boolean isOver(Point point) {
		int xLeft = this.position.x;
		int yTop = this.position.y;
		int xRight = xLeft + this.width();
		int yBotton = yTop + this.height();
		
		return ( (point.x > xLeft && point.x < xRight) &&
				(point.y > yTop && point.y < yBotton) );
	}

    protected void onMouseClick(MouseEvent me){

    }
  
    
}