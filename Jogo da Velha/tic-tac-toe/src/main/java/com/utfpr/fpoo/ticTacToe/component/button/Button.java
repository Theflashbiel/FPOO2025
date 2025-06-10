package com.utfpr.fpoo.ticTacToe.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

import com.utfpr.fpoo.ticTacToe.component.AbstractComponent;
import com.utfpr.fpoo.ticTacToe.component.button.ButtonClickEvent.MouseButton;
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

     g.drawRect(position.x, position.y, dimension.width, dimension.height);

    if (mouseOver)
      doMouseOverDecoration(g);

    
     
  }


  Set<ButtonClickListener> ButtonClickListeners = new HashSet<>();

  public void addButtonClickListener (ButtonClickListener listener){
      ButtonClickListeners.add(listener);
  }
  public void removeButtonClickListener (ButtonClickListener listener){
      ButtonClickListeners.remove(listener);
  }

  public void dispatchButtonClickEvent(MouseEvent me){
		MouseButton button = ((me.getButton() == MouseEvent.BUTTON1) ? MouseButton.LEFT :
			(me.getButton() == MouseEvent.BUTTON2) ? MouseButton.MIDLE :
			MouseButton.RIGHT );
		
			ButtonClickEvent event = new ButtonClickEvent(this, button);
			ButtonClickListeners.forEach(listener->listener.onClick(event));
	}
  @Override
  protected void onMouseClick (MouseEvent me){
    dispatchButtonClickEvent(me);
  }
}
