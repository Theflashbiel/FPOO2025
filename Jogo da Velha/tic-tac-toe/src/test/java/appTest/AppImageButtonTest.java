package appTest;


import java.net.URL;

import javax.swing.ImageIcon;

import com.utfpr.fpoo.ticTacToe.component.button.ImageButton;
import com.utfpr.fpoo.ticTacToe.gui.MainWindow;

    public class AppImageButtonTest {

   public static void main(String[] args) {

      final String path = "../ticTacToe/images/";
      URL url = AppImageButtonTest.class.getResource(path+ "tic-tac-toe.png");
      ImageIcon icon = new ImageIcon(url);

      ImageButton button = new ImageButton(100,100,50,50, icon);

      MainWindow window = new MainWindow();
      window.add(button);
      window.addMouseListener(button.mouseListener());
      window.addMouseMotionListener(button.mouseMotionListener());
    }
}