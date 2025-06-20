package appTest;
import com.utfpr.fpoo.ticTacToe.component.button.Button;
import com.utfpr.fpoo.ticTacToe.gui.MainWindow;


public class AppButtonPaintableTest {
    
    public static void main(String[] args) {
        MainWindow window = new MainWindow();

        Button button = new Button();
        window.add(button);
        
        button = new Button(100, 150);
        window.add(button);
        
        button = new Button(200, 200, 50, 50);
        window.add(button);

    }
}
