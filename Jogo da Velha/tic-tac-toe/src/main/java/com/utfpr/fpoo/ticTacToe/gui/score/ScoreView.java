package com.utfpr.fpoo.ticTacToe.gui.score;

import com.utfpr.fpoo.ticTacToe.component.AbstractComponent;
import com.utfpr.fpoo.ticTacToe.model.score.ReadOnlyScoreModel;
import com.utfpr.fpoo.ticTacToe.component.button.TextButton;

import javax.swing.ImageIcon;


import java.awt.Graphics;
public class ScoreView extends AbstractComponent {


    private ReadOnlyScoreModel scoreModel;
    private TextButton scoreX;
    private TextButton scoreO;
    private ImageIcon background;

    public ScoreView(int x, int y, int width, int height, ReadOnlyScoreModel scoreModel){

        super(x, y, width, height);
        this.scoreModel = scoreModel;

      
        this.scoreX = new TextButton(x + 10, y + 10, width / 2 - 20, height - 20);
        this.scoreX.setText("X: 0");
        this.scoreO = new TextButton(x + width / 2 + 10, y + 10, width / 2 - 20, height - 20);
        this.scoreO.setText("O: 0");

        refresh();
    }

    public void setBackground(ImageIcon background) {
        this.background = background;
    }

    private void updateScores() {

        this.scoreX.setText("X: " + scoreModel.scoreX());
        this.scoreO.setText("O: " + scoreModel.scoreO());
    }


    public void refresh() {
        updateScores();
    }

    @Override
    public void paint(Graphics g) {
        if (background != null) {
            g.drawImage(background.getImage(), position.x, position.y, width(), height(), null);
        }
        refresh();
        scoreX.paint(g);
        scoreO.paint(g);
    }
    
}
