package appTest;

import java.net.URL;

import javax.swing.ImageIcon;

import com.utfpr.fpoo.ticTacToe.gui.MainWindow;
import com.utfpr.fpoo.ticTacToe.model.score.SimpleScoreModel;
import com.utfpr.fpoo.ticTacToe.gui.score.ScoreView;

public class AppScoreTest {
    
    private SimpleScoreModel scoreModel;

    private ScoreView scoreView;
    private MainWindow window;

     private ImageIcon loadImage(String fileName) {

        String path = "../ticTacToe/images/";
        URL url = getClass().getResource(path + fileName);
        return new ImageIcon(url);

    }

    private void play(int times) throws InterruptedException {
        for(int i=0; i<times; i++){
            Thread.sleep(1_000);
            if(Math.random() < 0.5)
                scoreModel.incScoreX();
            else
                scoreModel.incScoreO();
        }
    }

    public AppScoreTest(){

        scoreModel = new SimpleScoreModel();
        scoreView = new ScoreView(100,100,200,100, scoreModel);
        ImageIcon background = loadImage("background.jpg");
       
        scoreView.setBackground (background);

        window = new MainWindow();
        window.add(scoreView);
    } 

    public static void main(String[] args)  throws InterruptedException {
        AppScoreTest test = new AppScoreTest();
        test.play(20);
    }

}
