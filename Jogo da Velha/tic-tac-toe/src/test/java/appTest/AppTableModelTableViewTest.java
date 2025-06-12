package appTest;

import java.net.URL;

import javax.swing.ImageIcon;

import com.utfpr.fpoo.ticTacToe.gui.MainWindow;
import com.utfpr.fpoo.ticTacToe.model.Mark;
import com.utfpr.fpoo.ticTacToe.model.table.SimpleTableModel;
import com.utfpr.fpoo.ticTacToe.gui.TableView;
import com.utfpr.fpoo.ticTacToe.model.table.TableModel;

public class AppTableModelTableViewTest {

    TableModel tableModel = new SimpleTableModel();

    MainWindow window = new MainWindow();
    TableView tableView = createTableView();

    private ImageIcon loadImage(String fileName) {

        String path = "../ticTacToe/images/";
        URL url = getClass().getResource(path + fileName);
        return new ImageIcon(url);

    }

    private TableView createTableView(){

        ImageIcon icon = loadImage("tic-tac-toe.png");
        TableView table = new TableView(0,0,200,200, icon);
        icon = loadImage("markX.png");
        table.setIconX(icon);
        icon = loadImage("markO.png");
        table.setIconO(icon);
        return table;

    }

    public AppTableModelTableViewTest(){

        tableView.setTableModel(tableModel);

        ImageIcon icon = loadImage("background.jpg");
        window.setBackground(icon);
        window.add(tableView);
    } 

    private void play() throws Exception{

        Thread.sleep(1000);
            tableModel.setMark(1, 1, Mark.X);
        Thread.sleep(1000);
            tableModel.setMark(0, 0, Mark.O);
        Thread.sleep(1000);
            tableModel.setMark(0, 1, Mark.X);
        Thread.sleep(1000);
            tableModel.setMark(2, 1, Mark.O);
        Thread.sleep(1000);
            tableModel.setMark(2, 0, Mark.X);
        Thread.sleep(1000);
            tableModel.setMark(0, 2, Mark.O);
        Thread.sleep(1000);
            tableModel.setMark(1, 0, Mark.X);
        Thread.sleep(1000);
            tableModel.setMark(1, 2, Mark.O);
        Thread.sleep(1000);
            tableModel.setMark(2, 2, Mark.X);
    }

    public static void main(String[] args) throws Exception{
        AppTableModelTableViewTest app = new AppTableModelTableViewTest();
        app.play();
    }
}
