package com.utfpr.fpoo.ticTacToe.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.utfpr.fpoo.ticTacToe.gui.Paintable;
import com.utfpr.fpoo.ticTacToe.gui.util.MouseListenerAdapter;

public class Button extends AbstractComponent {

  public Button() {
    super();
  }

  public Button(int x, int y) {
    super(x, y);
  }

  public Button(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  private void doMouseOverDecoration(Graphics g) {

    Color ant = g.getColor();
    g.setColor(Color.RED);
    g.drawRect(position.x + 2, position.y + 2, dimension.width - 4, dimension.height - 4);
    g.setColor(ant);

  }

  public void paint(Graphics g) {

    if (!mouseOver)
      g.drawRect(position.x, position.y, dimension.width, dimension.height);

    if (mouseOver)
      doMouseOverDecoration(g);
  }

}
