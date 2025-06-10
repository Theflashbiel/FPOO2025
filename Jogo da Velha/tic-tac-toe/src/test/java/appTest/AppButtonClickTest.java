package appTest;

import com.utfpr.fpoo.ticTacToe.component.button.Button;
import com.utfpr.fpoo.ticTacToe.gui.MainWindow;

public class AppButtonClickTest {
    
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        Button bLogin = new Button(100,100,50,50);
        window.add(bLogin);
        window.addMouseMotionListener(bLogin.mouseMotionListener());
        window.addMouseListener(bLogin.mouseListener());

        Button bCancel = new Button(160,100,50,50);
        window.add(bCancel);
        window.addMouseMotionListener(bCancel.mouseMotionListener());
        window.addMouseListener(bCancel.mouseListener());

        bLogin.addButtonClickListener(event->{
            System.out.print("voce cliclou Login\n");
        });

        bCancel.addButtonClickListener(event->{
            System.out.print("voce cliclou Cancel\n");
        });
    }
}
