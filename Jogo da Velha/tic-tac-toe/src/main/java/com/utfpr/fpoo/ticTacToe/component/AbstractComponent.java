package com.utfpr.fpoo.ticTacToe.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.utfpr.fpoo.ticTacToe.gui.Paintable;
import com.utfpr.fpoo.ticTacToe.gui.util.MouseListenerAdapter;
import com.utfpr.fpoo.ticTacToe.gui.util.MouseMotionAdapter;

public abstract class AbstractComponent implements Paintable {

    protected Point position;
    protected Dimension dimension;
    protected boolean mouseOver = false;

    public AbstractComponent() {
        this.position = new Point(0, 0);
        this.dimension = new Dimension(20, 20);
    }

    public AbstractComponent(int x, int y) {
        this.position = new Point(x, y);
        this.dimension = new Dimension(20, 20);
    }

    public AbstractComponent(int x, int y, int width, int height) {
        this.position = new Point(x, y);
        this.dimension = new Dimension(width, height);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setSize(int width, int height) {
        this.dimension = new Dimension(width, height);

    }

    public Dimension getDimension() {
        return (Dimension) this.dimension.clone();
    }

    public int width() {
        return this.dimension.width;
    }

    public int height() {
        return this.dimension.height;
    }

    public boolean isOver(Point point) {
        int xLeft = this.position.x;
        int yTop = this.position.y;
        int xRight = xLeft + this.width();
        int yButton = yTop + this.height();

        return ((point.x > point.y && point.x < xRight) && (point.y > yTop && point.y < yButton));
    }

    public MouseListener mouseListener() {

        return new MouseListenerAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (!isOver(me.getPoint()))
                    return;

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

}
